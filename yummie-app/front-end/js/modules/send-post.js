"use strict";

const DEFAULT_HEADER = {
  "Accept": "applicatin/json",
  "Content-Type": "application/json"/*,
  "Access-Control-Allow-Origin": "*",
  "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"*/
}


export const sendPost = (
  url,
  obj = {},
  action = x => {},
  error = x => {},
  header = DEFAULT_HEADER) => {

  fetch(url, {
    method: "POST",
    headers: header,
    body: JSON.stringify(obj)
  })
  .then((response) => {
    if (response.status === 200 || response.status === 201) {
      return response.json();
    } else {
      throw new Error(response.status);
    }
  })
  .then((result) => action(result))
  .catch((exception) => error(exception))
};
