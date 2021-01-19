const fs = require("fs");
const stdin = (process.platform === "linux" ?
        fs
        .readFileSync("/dev/stdin")
        .toString()
        .trim() :
        `2
3 ABC
5 /HTP`
).split("\n");

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let time = input();
let arr = [];
while (time--) {
        let [n, s] = input().split(" ");
        for (let i = 0; i < s.trim().length; i++) {
                for (let j = 0; j < +n; j++) {
                        process.stdout.write(s[i]);
                }
        }
        process.stdout.write("\n");
}