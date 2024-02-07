function sortAlphabetically(str) {
  // Convert string to array, sort the array alphabetically, and join back to a string;
  return str.split("").sort().join("");
}
//Example usage
var str = "webmaster";
var sortedStr = sortAlphabetically(str);
console.log(sortedStr); // Output: abeemrstw
