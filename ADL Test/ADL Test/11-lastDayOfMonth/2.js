function lastday(year, month) {
    return new Date(year, month + 1, 0).getDate();
}

// In this example, we use the Date object to create a new date for the first
// day of the next month (month + 1) in the specified year. We then subtract
// one day from this date by setting the day of the month to 0 using the
// getDate() method, which returns the last day of the specified month.
// To test this function, you can call it with different year and month values:

console.log(lastday(2014,0));
console.log(lastday(2014,1));
console.log(lastday(2014,11));