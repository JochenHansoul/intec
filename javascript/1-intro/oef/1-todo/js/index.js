"use strict";

const URL = "https://jsonplaceholder.typicode.com/";
const URL_TODO = URL + "todos/";

const ARTICLE_TODO = document.getElementById("js-todo-article");

const removeAllChildren = (element) => {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
}

const replaceAllContent = (element, string) => {
  removeAllChildren(element);
  element.appendChild(document.createTextNode(string));
}

const idQuery = (ids, idName = "id") => {
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

const addData = (element, data) => {
  for (let d of data) {
    let s = d.title + ", completed: " + d.completed;
    element.appendChild(document.createTextNode(s));
    element.appendChild(document.createElement("br"));
  }
  element.lastChild.remove();
}

// input: element, url, function(element, data)
const fetchAndAddData = (element, url, addData) => {
  fetch(url)
    .then(response => {
      if (response.status === 200) {
        return response.json();
      } else {
        throw new Error("getAndAddDate error with status " + response.status);
      }
    })
    .then(data => addData(element, data))
    .catch(e => console.log(e));
}

const addTodo = (element, id) => {
  fetch(URL_TODO + id)
    .then(response => response.json())
    .then(todo => {
      replaceAllContent(element, todo.title + ", completed: " + todo.completed);
    })
}

let urlTodos = URL_TODO + idQuery([1, 2, 3]);
fetchAndAddData(ARTICLE_TODO, urlTodos, addData);
