"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const LATTITUDES = RESTAURANT_FORM.querySelectorAll(".lattitude input");
const LONGITUDES = RESTAURANT_FORM.querySelectorAll(".longitude input");
const OUTPUT = RESTAURANT_FORM.querySelector("output");
const TABLE = document.getElementsByClassName("restaurant-table")[0];
const RESTAURANT_TABLE = document.getElementById("restaurant-tbody");

const ID = sessionStorage.getItem("user-id");

// functions
const removeChildren = element => {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
};

const createTable = tableData => {
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
  for (const RESTAURANT of restaurants) {
    const RESTAURANT_DATA = [RESTAURANT.name, RESTAURANT.location.latitude, RESTAURANT.location.longitude];
    RESTAURANT_TABLE.append(createTable(RESTAURANT_DATA));
  }
};

const sendError = error => OUTPUT.innerText = "Error: " + error.message;

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  removeChildren(RESTAURANT_TABLE);
  const LOCATION = {
    lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
    longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
  };
  sendPost(RESTAURANT_FORM.action + "?id=" + ID, LOCATION, sendResponse, sendError);
});
