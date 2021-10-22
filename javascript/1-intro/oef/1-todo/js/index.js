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

const processData = (data) => {
  let array = [];
  for (let d of data) {
    array.push(d.title + ", completed: " + d.completed);
  }
  return array;
}

const displayDataDefault = (element, data) => {
  for (let row of data) {
    element.appendChild(document.createTextNode(row));
    element.appendChild(document.createElement("br"));
  }
  element.lastChild.remove();
}

// input: element, url, function(element, data)
const fetchAndAddData = (element, url, processData, displayData = displayDataDefault) => {
  fetch(url)
    .then(response => {
      if (response.status === 200) {
        return response.json();
      } else {
        throw new Error("getAndAddDate error with status " + response.status);
      }
    })
    .then(data => processData(data))
    .then(array => displayData(element, array))
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
fetchAndAddData(ARTICLE_TODO, urlTodos, processData);
