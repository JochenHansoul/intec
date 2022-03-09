"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
const LATTITUDES = RESTAURANT_FORM.querySelectorAll("p[name=\"lattitude\"] label input");
const LONGITUDES = RESTAURANT_FORM.querySelectorAll("p[name=\"longitude\"] label input");
const RESPONSE_OUTPUT = RESTAURANT_FORM.getElementsByTagName("output").response;

// functions
const sendResponse = x => RESPONSE_OUTPUT.innerText = "Restaurant succesfully saved";
const sendError = x => RESPONSE_OUTPUT.innerText = "Could not save restaurant. Error: " + x.message;

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  // creating location
  const RESTAURANT = {
    idUser: 1,
    name: INPUTS.name.value,
    location: {
      lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
      longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
    },
    file: INPUTS.certificate.value
  };
  sendPost(RESTAURANT_FORM.action, RESTAURANT, sendResponse, sendError);
});
