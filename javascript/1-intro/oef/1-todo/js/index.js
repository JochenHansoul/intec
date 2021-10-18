"use strict";

const H1_TITLE = document.getElementById("js-title");

function removeAllChildren(element) {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
}

removeAllChildren(H1_TITLE);
H1_TITLE.appendChild(document.createTextNode("hello, world"));
