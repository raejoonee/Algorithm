const fs = require("fs");
const { setPriority } = require("os");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `80875542`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let N = input().split("").map(e => parseInt(e));
if (!N.includes(0)) console.log(-1);
else {
    if (N.reduce((pre, cur) => pre + cur) % 3) console.log(-1);
    else {
        console.log(N.sort((a, b) => b - a).join(""));
    }
}
