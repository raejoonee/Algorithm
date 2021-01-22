const fs = require("fs");
const stdin = (process.platform === "linux"
  ? fs
      .readFileSync("/dev/stdin")
      .toString()
      .trim()
  : `7
6 4 10 2 5 7 11`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let repeatTime = parseInt(input());
let arr = input()
  .split(" ")
  .map(element => parseInt(element));
let ans = 0;
let curKill = 0;

arr.reduce((prev, cur, idx, arr) => {
  if (cur > prev) {
    curKill = 0;
    prev = cur;
  }
  if (prev > arr[idx + 1]) curKill++;
  if (curKill > ans) {
    ans = curKill;
  }
  return prev;
}, 0);

console.log(ans);
