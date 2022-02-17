"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const LATTITUDES = RESTAURANT_FORM.querySelectorAll(".lattitude input");
const LONGITUDES = RESTAURANT_FORM.querySelectorAll(".longitude input");
const OUTPUT = RESTAURANT_FORM.querySelector("output");

// functions
const sendResponse = response => OUTPUT.innerText = "Succesfull: " + response;
const sendError = error => OUTPUT.innerText = "Error: " + error.message;

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const LOCATION = {
    lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
    longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
  };
  sendPost(RESTAURANT_FORM.action, LOCATION, sendResponse, sendError);
});
