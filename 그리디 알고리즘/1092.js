const fs = require("fs");
const stdin = (process.platform === "linux"
  ? fs
      .readFileSync("/dev/stdin")
      .toString()
      .trim()
        : `3
99 1
7
99 99 99 99 1`
).split("\n");

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let N = input();
let craneList = input().split(" ").map(e => parseInt(e)).sort((a, b) => b - a);
let M = input();
let boxList = input().split(" ").map(e => parseInt(e)).sort((a, b) => b - a);

if (craneList[0] < boxList[0]) {
        console.log(-1);
        return ;
}
let answer = 0;
while (boxList.length) {
        for (let crane of craneList) {
                if (!boxList.length) break;
                for (let box of boxList) {
                        if (crane >= box) {
                                boxList.splice(boxList.indexOf(box), 1);
                                break;
                        }
                }
        }
        answer++;
}
console.log(answer);