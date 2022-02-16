"use strict";

// functions
const sendResponse = x => { console.log(x); };
const sendError = x => { console.log(x); };

const calculateCoordinate = (degrees, minutes, seconds, range) => {
  const N = parseInt(degrees);
  const RESULT = Math.abs(N) + (parseInt(minutes) / 60) + (parseInt(seconds) / 60);
  if (RESULT > range) {
    throw new Exception("must be between -" + range + "and "+ range);
  } else {
    return (N < 0) ? RESULT * -1 : RESULT;
  }
};

const calculateLattitude = (degrees, minutes, seconds) => {
  return calculateCoordinate(degrees, minutes, seconds, 90);
};

const calculateLongitude = (degrees, minutes, seconds) => {
  return calculateCoordinate(degrees, minutes, seconds, 180);
};

// constants
const RESTAURANT_FORM = document.forms.restaurant;


// main
RESTAURANT_FORM.addEventListener("submit", event => {
  event.preventDefault();
  // location
  const LATTITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(2) label input");
  const LONGITUDES = RESTAURANT_FORM.querySelectorAll("p:nth-child(3) label input");
  const LOCATION = {
    lattitude: calculateLattitude(LATTITUDES[0].value, LATTITUDES[1].value, LATTITUDES[2].value),
    longitude: calculateLongitude(LONGITUDES[0].value, LONGITUDES[1].value, LONGITUDES[2].value)
  };

  // restaurant
  const INPUTS = RESTAURANT_FORM.getElementsByTagName("input")
  const RESTAURANT = {
    name: INPUTS.restaurantName.value,
    location: LOCATION,
    file: INPUTS.certificate.value
  };
  console.log(RESTAURANT);

  /*if (INPUTS[0].value === INPUTS[1].value) {
    const user = getFormObject(USER_FORM);
    sendPost(USER_FORM.action, user, sendResponse, sendError);
  } else {
    USER_FORM.querySelector("output[name=\"password\"]")
      .innerText = "passwords are not the same";
  }*/
});
