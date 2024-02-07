// string with whitespace
function alpha(str) 
{
    var arr = str.split("");
    res = arr.sort().join("");
    rws = res.replace(/\s+/g, "");
    return rws;
}

console.log("taking geeksforgeeks portal as a string");
console.log(alpha("geeksforgeeks portal"));