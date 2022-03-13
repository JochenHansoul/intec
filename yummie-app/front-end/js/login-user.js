"use strict";

// constants
const USER_FORM = document.forms.user;
const FORM_OUTPUT = USER_FORM.querySelector("output[name=\"response\"]");

// functions
const sendResponse = user => {
  loginUser(user);
  location.href = "file:///home/jochenhansoul/Projects/intec/yummie-app/front-end/find-restaurants.html";
};

const sendError = error => {
  FORM_OUTPUT.replaceChildren(document.createTextNode("Error creating user: " + error.message));
};

// main
USER_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const O = getFormObject(USER_FORM);
  sendPost(USER_FORM.action, O, sendResponse, sendError);
});
