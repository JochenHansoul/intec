"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
const LATTITUDES = RESTAURANT_FORM.children.lattitude.getElementsByTagName("input");
const LONGITUDES = RESTAURANT_FORM.children.longitude.getElementsByTagName("input");
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
      lattitude: calculateLattitude(LATTITUDES.degrees.value, LATTITUDES.minutes.value, LATTITUDES.seconds.value),
      longitude: calculateLongitude(LONGITUDES.degrees.value, LONGITUDES.minutes.value, LONGITUDES.seconds.value)
    },
    file: INPUTS.certificate.value
  };
  sendPost(RESTAURANT_FORM.action, RESTAURANT, sendResponse, sendError);
});
