"use strict";

// constants
const RESTAURANT_FORM = document.forms.restaurant;
const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
const OUTPUTS = RESTAURANT_FORM.querySelectorAll("output");
const LATTITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(2) label input");
const LONGITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(3) label input");

// functions
const calculateCoordinate = (degrees, minutes, seconds) => {
  const N = parseInt(degrees);
  const RESULT = Math.abs(N) + (parseInt(minutes) / 60) + (parseInt(seconds) / 60);
  return (N < 0) ? RESULT * -1 : RESULT;
};

const sendResponse = x => OUTPUTS[2].innerText = "Restaurant succesfully saved";

const sendError = x => OUTPUTS[2].innerText = "Could not save restaurant. Error: " + x.message;


// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();

  // clearing output fields
  OUTPUTS.forEach(output => output.innerText = "");

  // location verification
  const LATTITUDE = calculateCoordinate(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value);
  const LONGITUDE = calculateCoordinate(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value);
  if (LATTITUDE < -90 || LATTITUDE > 90) {
    OUTPUTS[0].innerText = "lattitude must be between -90 and 90";
    if (LONGITUDE < -180 || LONGITUDE > 180) {
      OUTPUTS[1].innerText = "longitude must be between -180 and 180";
    }
  } else if (LONGITUDE < -180 || LONGITUDE > 180) {
      OUTPUTS[1].innerText = "longitude must be between -180 and 180";
  } else {
    // creating and sending form object
    const RESTAURANT = {
      idUser: 1,
      name: INPUTS.restaurantName.value,
      location: {
        lattitude: LATTITUDE,
        longitude: LONGITUDE
      },
      file: INPUTS.certificate.value
    };
    sendPost(RESTAURANT_FORM.action, RESTAURANT, sendResponse, sendError);
  }
});
