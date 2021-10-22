"use strict";

const URL = "https://jsonplaceholder.typicode.com/";
const URL_TODO = URL + "todos/";

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

function addTodo(element, id) {
  fetch(URL_TODO + id)
    .then(response => response.json())
    .then(todo => {
      replaceAllContent(element, todo.title + ", completed: " + todo.completed);
    })
}

addTodo(H1_TITLE, 4);
