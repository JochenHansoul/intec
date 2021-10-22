"use strict";

const URL = "https://jsonplaceholder.typicode.com/";
const URL_TODO = URL + "todos/";

const P_TODO = document.getElementById("js-todo-paragraph");


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

const displayDataDefault = (element, data) => {
  for (let row of data) {
    element.appendChild(document.createTextNode(row));
    element.appendChild(document.createElement("br"));
  }
  element.lastChild.remove();
}

// input: element, url, processData(data), displayData(element, data)
const fetchAndAddData = (
  element,
  url,
  processData,
  displayData = displayDataDefault) => {

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

const processTodoData = (data) => {
  let array = [];
  for (let d of data) {
    array.push(d.title + ", completed: " + d.completed);
  }
  return array;
}

fetchAndAddData(P_TODO, URL_TODO + idQuery([1, 2, 3]), processTodoData);
