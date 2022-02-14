"use strict";

// functions
const sendResponse = x => { console.log(x); };
const sendError = x => { console.log(x); };

// constants
const USER_FORM = document.forms.user;


// main
USER_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const INPUTS = USER_FORM.querySelectorAll("input[type=\"password\"]");
  if (INPUTS[0].value === INPUTS[1].value) {
    const user = getFormObject(USER_FORM);
    sendPost(USER_FORM.action, user, sendResponse, sendError);
  } else {
    USER_FORM.querySelector("output[name=\"password\"]")
      .innerText = "passwords are not the same";
  }
});
