const fs = require("fs");

const inputData = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let curHeight = input.reduce((pre, cur) => +pre + +cur);
  let picked = pick(input, curHeight);
  input.splice(input.indexOf(picked[0]), 1);
  input.splice(input.indexOf(picked[1]), 1);
  input.sort((a, b) => {
    return a - b;
  });
  return input;
}

function answer(input) {
  solution(input);
  for (let a of input) {
    console.log(a);
  }
}

function pick(input, curHeight) {
  for (let first of input) {
    for (let second of input) {
      if (first === second) continue;
      if (curHeight - +first - +second === 100) return [first, second];
    }
  }
  return [0, 0];
}

answer(inputData);
