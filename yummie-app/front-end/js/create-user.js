"use strict"

const getFormObject = form => {
    const inputs = form.getElementsByTagName("input")
    return Array.prototype.slice.call(inputs).reduce(
        (obj, tag) => {
            obj[tag.name] = tag.value;
            return obj;
        },
        {}
    );
}

const form = document.forms[0];
const user = getFormObject(form);
console.log(user);
