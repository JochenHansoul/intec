export const removeAllChildren = (element) => {
  while (element.hasChildNodes()) {
    element.lastChild.remove();
  }
}

export const replaceAllContent = (element, string) => {
  removeAllChildren(element);
  element.appendChild(document.createTextNode(string));
}
