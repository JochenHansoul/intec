exports.removeAllChildren = (element) => {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
}

exports.replaceAllContent = (element, string) => {
  removeAllChildren(element);
  element.appendChild(document.createTextNode(string));
}
