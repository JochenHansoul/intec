"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
const LATTITUDES = RESTAURANT_FORM.children.lattitude.getElementsByTagName("input");
const LONGITUDES = RESTAURANT_FORM.children.longitude.getElementsByTagName("input");
const RESPONSE_OUTPUT = RESTAURANT_FORM.getElementsByTagName("output").response;

// functions
const sendResponse = response => {
  RESPONSE_OUTPUT
    .replaceChildren(document.createTextNode("Restaurant succesfully saved"));
};
const sendError = error => {
  RESPONSE_OUTPUT
    .replaceChildren(document.createTextNode("Could not save restaurant. Error: " + error.message));
};

// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  // creating location
  const RESTAURANT = {
    idUser: sessionStorage.getItem("id-user"),
    name: INPUTS.name.value,
    location: {
      lattitude: calculateLattitude(
        parseInt(LATTITUDES.degrees.value),
        parseInt(LATTITUDES.minutes.value),
        parseInt(LATTITUDES.seconds.value)),
      longitude: calculateLongitude(
        parseInt(LONGITUDES.degrees.value),
        parseInt(LONGITUDES.minutes.value),
        parseInt(LONGITUDES.seconds.value))
    },
    file: INPUTS.certificate.value
  };
  sendPost(RESTAURANT_FORM.action, RESTAURANT, sendResponse, sendError);
});
