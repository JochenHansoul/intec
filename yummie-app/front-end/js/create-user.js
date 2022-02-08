"use strict";

// constants
const USER_FORM = document.forms.user;
//const SUBMIT_BUTTON = USER_FORM.getElementsByTagName("button")[0];

// functions
const getFormObject = form => {
    const inputs = form.getElementsByTagName("input")
    return Array.prototype.slice.call(inputs).reduce(
        (obj, tag) => {
            obj[tag.name] = tag.value;
            return obj;
        },
        {}
    );
};

const sendObject = (url, obj, method = "GET") => {
  fetch(url, {
    method: method,
    body: JSON.stringify(obj),
    headers: {
      "Accept": "applicatin/json",
      "Content-Type": "application/json"
    }
  })
  .then((response) => {
    if (response.status === 201) {
      console.log("correct status");
      return response.json();
    } else {
      throw new Error("error with status " + response.status);
    }
  })
  .then((result) => {
    console.log("inside result block");
    console.log(result);
  })
  .catch((exception) => {
    console.log("inside exception block");
    console.log(exception.message);
  })
};

// main
USER_FORM.addEventListener("submit", event=> {
  event.preventDefault();
  const user = getFormObject(USER_FORM.user);
  user["emails"] = [getFormObject(USER_FORM.email)];
  sendObject(USER_FORM.action, user, USER_FORM.method);
});
