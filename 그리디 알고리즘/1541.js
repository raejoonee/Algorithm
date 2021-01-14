const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

function summation(input) {
  if (!input.length) return 0;
  return input.split("+").reduce((pre, val) => +pre + +val);
}

function solution(input) {
  let arr = input.split("-");
  let plus = summation(arr.shift());
  let minus = 0;
  for (let exp of arr) {
    minus += +summation(exp);
  }
  return plus - minus;
}

console.log(solution(input));
