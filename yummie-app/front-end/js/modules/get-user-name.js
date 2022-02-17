"use strict";

const USER_NAME_INPUT = document.getElementById("user-name");

const USER_NAME_LOCAL_STORAGE = window.localStorage.getItem("nameUser");
console.log("nameUser:");
console.log(window.localStorage.getItem("nameUser"));
console.log(USER_NAME_LOCAL_STORAGE);

if (USER_NAME_LOCAL_STORAGE !== null) {
  //USER_NAME_INPUT.innerText = USER_NAME_LOCAL_STORAGE;
  USER_NAME_INPUT.append(USER_NAME_LOCAL_STORAGE);
}

