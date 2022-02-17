"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
const OUTPUTS = RESTAURANT_FORM.querySelectorAll("output");
const LATTITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(2) label input");
const LONGITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(3) label input");

// functions
const sendResponse = x => OUTPUTS[2].innerText = "Restaurant succesfully saved";
const sendError = x => OUTPUTS[2].innerText = "Could not save restaurant. Error: " + x.message;

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  // creating location
  const RESTAURANT = {
    idUser: 1,
    name: INPUTS.restaurantName.value,
    location: {
      lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
      longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
    },
    file: INPUTS.certificate.value
  };
  sendPost(RESTAURANT_FORM.action, RESTAURANT, sendResponse, sendError);
});
