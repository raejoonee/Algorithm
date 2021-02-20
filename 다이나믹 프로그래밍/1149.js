const fs = require("fs");
const stdin = (process.platform === "linux"
  ? fs
      .readFileSync("/dev/stdin")
      .toString()
      .trim()
  : `3
26 40 83
49 60 57
13 89 99`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let repeatTime = parseInt(input()) - 1;
let [r, g, b] = input()
  .split(" ")
  .map(element => parseInt(element.trim()));
while (repeatTime--) {
  let [rr, gg, bb] = input()
    .split(" ")
    .map(element => parseInt(element.trim()));
  rr = Math.min(g, b) + rr;
  gg = Math.min(r, b) + gg;
  bb = Math.min(r, g) + bb;
  r = rr;
  g = gg;
  b = bb;
}
console.log(Math.min(r, g, b));
