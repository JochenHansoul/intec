"use strict";

// constants
const USER_FORM = document.forms.user;

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

const sendObject = (url, obj) => {
  fetch(url, {
    method: "POST",
    body: JSON.stringify(obj),
    headers: {
      "Accept": "applicatin/json",
      "Access-Control-Allow-Origin": "*", // paybe problem with addblocker?
      "Content-Type": "application/json"
    }
  })
  .then((response) => {
    if (response.status === 201) {
      return response.json();
    } else {
      throw new Error("error with status " + response.status);
    }
  })
  .then((result) => {
    console.log(result);
  })
  .catch((exception) => {
    console.log(exception);
  })
};

// main
USER_FORM.addEventListener("submit", event => {
  event.preventDefault();
  const user = getFormObject(USER_FORM);
  sendObject(USER_FORM.action, user);
});
