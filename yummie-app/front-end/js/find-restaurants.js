"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const LATTITUDES = RESTAURANT_FORM.querySelector("#lattitude")
  .getElementsByTagName("input");
const LONGITUDES = RESTAURANT_FORM.querySelector("#longitude")
  .getElementsByTagName("input");
const OUTPUT = RESTAURANT_FORM.getElementsByTagName("output").response;
const TABLE = document.getElementById("restaurant-table");
const RESTAURANT_TABLE = document.getElementById("restaurant-tbody");

// functions
const createTableRow = tableData => {
  const TR = document.createElement("tr");
  for (const D of tableData) {
    const C = document.createElement("td");
    C.textContent = D
    TR.append(C);
  }
  return TR;
};

const sendResponse = restaurants => {
  TABLE.classList.remove("hidden");
  RESTAURANT_TABLE.replaceChildren(...(restaurants.map(restaurant => {
    return createTableRow([restaurant.name, restaurant.location.latitude, restaurant.location.longitude]);
  })));
};

const sendError = error => OUTPUT.innerText = "Error: " + error.message;

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const LOCATION = {
    lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
    longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
  };
  sendPost(
    RESTAURANT_FORM.action + "?id=" + sessionStorage.getItem("id-user"),
    LOCATION,
    sendResponse,
    sendError);
});
