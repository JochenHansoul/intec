"use strict";

// elements
const FULL_NAME_INPUT = document.getElementById("js-full-name");
const LOGOUT_ELEMENT = document.getElementById("js-logout-user");

const LOGIN_DROPDOWN_LIST = document.querySelectorAll(".dropdown-list")[0];
const LOGOUT_DROPDOWN_LIST = document.querySelectorAll(".dropdown-list")[1];
// session storage
const ID_SESSION_STORAGE = sessionStorage.getItem("id-user");


// functions
const loginUser = user => {
  sessionStorage.setItem("id-user", user.idUser);
  sessionStorage.setItem("first-name", user.firstName);
  sessionStorage.setItem("last-name", user.lastName);
};

const logoutUser = () => {
  Object.keys(sessionStorage).forEach(key => sessionStorage.removeItem(key));
};

// main
if (ID_SESSION_STORAGE !== null) {
  // displays the username inside the header
  FULL_NAME_INPUT.append(
    sessionStorage.getItem("first-name") + " " + sessionStorage.getItem("last-name"));
  // changing registrate/login dropdown list to logout dropdown list
  LOGIN_DROPDOWN_LIST.classList.add("hidden");
  LOGOUT_DROPDOWN_LIST.classList.remove("hidden");
  // added logout click event
  LOGOUT_ELEMENT.addEventListener("click", event => {
    logoutUser();
    location.href = "file:///home/jochenhansoul/Projects/intec/yummie-app/front-end/index.html";
  });
}
