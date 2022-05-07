"use strict";

import { sendPost } from "./modules/send-post.js";
import { calculateLattitude, calculateLongitude } from "./modules/coordinates.js";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const LATTITUDES = RESTAURANT_FORM.children.lattitude.getElementsByTagName("input");
const LONGITUDES = RESTAURANT_FORM.children.longitude.getElementsByTagName("input");
const OUTPUT = RESTAURANT_FORM.getElementsByTagName("output").response;
const TABLE = document.getElementById("restaurant-table");
const RESTAURANT_TABLE = document.getElementById("restaurant-tbody");

// functions
const createTableRow = dataList => {
  const TR = document.createElement("tr");
  dataList.forEach(data => {
    const TD = document.createElement("td");
    TD.appendChild(document.createTextNode(data));
    TR.append(TD);
  });
  return TR;
};

const sendResponse = restaurants => {
  TABLE.classList.remove("hidden");
  RESTAURANT_TABLE.replaceChildren(...(restaurants.map(restaurant => {
    return createTableRow([restaurant.name, restaurant.location.latitude, restaurant.location.longitude]);
  })));
};

const sendError = error => OUTPUT.replaceChildren(document.createTextNode("Error: " + error.message));

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const LOCATION = {
    lattitude: calculateLattitude(LATTITUDES.degrees.value, LATTITUDES.minutes.value, LATTITUDES.seconds.value),
    longitude: calculateLongitude(LONGITUDES.degrees.value, LONGITUDES.minutes.value, LONGITUDES.seconds.value)
  };
  sendPost(
    RESTAURANT_FORM.action + "?id=" + sessionStorage.getItem("id-user"),
    LOCATION,
    sendResponse,
    sendError);
});
