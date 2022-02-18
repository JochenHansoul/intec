"use strict";

const USER_NAME_INPUT = document.getElementById("user-name");

const USER_NAME_LOCAL_STORAGE = window.sessionStorage.getItem("name-user");
console.log("nameUser:");
console.log(window.sessionStorage.getItem("name-user"));
console.log(USER_NAME_LOCAL_STORAGE);

if (USER_NAME_LOCAL_STORAGE !== null) {
  USER_NAME_INPUT.append(USER_NAME_LOCAL_STORAGE);
}

