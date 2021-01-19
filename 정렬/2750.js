const fs = require("fs");
const stdin = (process.platform === "linux" ?
        fs
        .readFileSync("/dev/stdin")
        .toString()
        .trim() :
        `5
5
2
3
4
1`
).split("\n");

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let time = input();
let arr = [];
while (time--) {
        arr.push(input());
}
arr.sort((a, b) => {
        return a - b;
});
for (let num of arr) console.log(num);