"use strict";

// functions
const sendResponse = x => { console.log(x); };
const sendError = x => { console.log(x); };

// constants
const USER_FORM = document.forms.user;

// main
USER_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const user = getFormObject(USER_FORM.user);
  user["emails"] = [getFormObject(USER_FORM.email)];
  sendPost(USER_FORM.action, user, sendResponse, sendError);
});
