"use strict";

import { getFormObject } from "./modules/get-form-object.js";
import { sendPost } from "./modules/send-post.js";

// constants
const USER_FORM = document.forms.user;
const PASSWORD_INPUTS = USER_FORM.querySelectorAll("input[type=\"password\"]");
const PASSWORD_OUTPUT = USER_FORM.querySelector("output[name=\"password\"]");
const FORM_OUTPUT = USER_FORM.querySelector("output[name=\"response\"]");

// functions
const sendResponse = user => {
  loginUser(user);
  //location.href = "file:///home/jochenhansoul/Projects/intec/yummie-app/front-end/find-restaurants.html";
  location.href = location.origin + "/find-restaurants.html"
};

const sendError = error => {
  FORM_OUTPUT.replaceChildren(document.createTextNode("Error creating user: " + error.message));
};

// main
USER_FORM.addEventListener("submit", event => {
  event.preventDefault();
  if (PASSWORD_INPUTS[0].value === PASSWORD_INPUTS[1].value) {
    const USER = getFormObject(USER_FORM);
    sendPost(USER_FORM.action, USER, sendResponse, sendError);
  } else {
    PASSWORD_OUTPUT.innerText = "passwords are not the same";
  }
});
