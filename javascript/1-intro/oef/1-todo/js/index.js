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

function idQuery(ids, idName = "id") {
  if (ids.length === 0) {
    return "";
  } else if (ids.length === 1) {
    return "" + ids[0];
  } else {
    let output = "?";
    for (let id of ids) {
      output += `${idName}=${id}&`;
    }
    return output.slice(0, output.length - 1);
  }
}

function addTodo(element, id) {
  fetch(URL_TODO + id)
    .then(response => response.json())
    .then(todo => {
      replaceAllContent(element, todo.title + ", completed: " + todo.completed);
    })
}

console.log(idQuery([5, 2, 3]));
addTodo(H1_TITLE, 4);
