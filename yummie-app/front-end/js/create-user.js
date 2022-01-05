"use strict"

const getFormObject = form => {
    const o = {};
    for (const element of form.getElementsByTagName("input")) {
        o[element.name] = element.value;
    }
    return o;
}

const form = document.forms[0];
const user = getFormObject(form);
console.log(user);
