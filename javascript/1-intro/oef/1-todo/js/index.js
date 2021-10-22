"use strict";

const URL = "https://jsonplaceholder.typicode.com/";
const URL_TODO = URL + "todos/";

const ARTICLE_TODO = document.getElementById("js-todo-article");

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

function addTodosGenerator(element) {
  return function (todos) {
    for (let todo of todos) {
      let s = todo.title + ", completed: " + todo.completed;
      element.appendChild(document.createTextNode(s));
      element.appendChild(document.createElement("br"));
    }
    element.lastChild.remove();
  }
}

function fetchAndAddData(url, addData) {
  fetch(url)
    .then(response => {
      if (response.status === 200) {
        return response.json();
      } else {
        throw new Error("getAndAddDate error with status " + response.status);
      }
    })
    .then(data => addData(data))
    .catch(e => console.log(e));
}

function addTodo(element, id) {
  fetch(URL_TODO + id)
    .then(response => response.json())
    .then(todo => {
      replaceAllContent(element, todo.title + ", completed: " + todo.completed);
    })
}

fetchAndAddData(URL_TODO + idQuery([1, 2, 3]), addTodosGenerator(ARTICLE_TODO));
console.log(idQuery([5, 2, 3]));
