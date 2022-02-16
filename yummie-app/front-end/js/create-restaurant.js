"use strict";

// functions
const sendResponse = x => { console.log(x); };
const sendError = x => { console.log(x); };

const calculateCoordinate = (degrees, minutes, seconds) => {
  const N = parseInt(degrees);
  const RESULT = Math.abs(N) + (parseInt(minutes) / 60) + (parseInt(seconds) / 60);
  return (N < 0) ? RESULT * -1 : RESULT;
};


// constants
const RESTAURANT_FORM = document.forms.restaurant;


// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  // location verification
  const LATTITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(2) label input");
  const LONGITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(3) label input");

  const LATTITUDE = calculateCoordinate(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value);
  const LONGITUDE = calculateCoordinate(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value);

  const OUTPUTS = RESTAURANT_FORM.querySelectorAll("output");
  if (LATTITUDE < -90 || LATTITUDE > 90) {
      OUTPUTS[0].innerText = "lattitude must be between -90 and 90";
  } else if (LONGITUDE < -180 || LONGITUDE > 180) {
      OUTPUTS[1].innerText = "longitude must be between -180 and 180";
  } else {
    // creating and sending form object
    const INPUTS = RESTAURANT_FORM.getElementsByTagName("input");
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
