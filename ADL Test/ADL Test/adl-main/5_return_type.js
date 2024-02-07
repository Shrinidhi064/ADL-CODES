function getType(val) {
  return typeof val;
}
//Example usage
console.log(getType("Hello World")); // Output: string
console.log(getType(42)); // Output: number
console.log(getType(true)); // Output: boolean
console.log(getType({})); // Output: object
console.log(getType(function () {})); // Output: function
console.log(getType(undefined)); // Output: undefined
