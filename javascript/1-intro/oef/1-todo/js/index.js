"use strict";

const H1_TITLE = document.getElementById("js-title");

function removeAllChildren(element) {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
}

function replaceAllContent(element, string) {
  removeAllChildren(element);
  element.appendChild(document.createTextNode(string));
}

fetch("https://jsonplaceholder.typicode.com/todos/1")
  .then(response => response.json())
  .then(todo => replaceAllContent(H1_TITLE, todo.title));
