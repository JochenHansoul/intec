"use strict";

const USER_NAME_INPUT = document.getElementById("user-name");

const USER_NAME_LOCAL_STORAGE = window.sessionStorage.getItem("name-user");

if (USER_NAME_LOCAL_STORAGE !== null) {
  USER_NAME_INPUT.append(USER_NAME_LOCAL_STORAGE);
}

