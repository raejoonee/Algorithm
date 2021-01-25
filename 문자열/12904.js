const fs = require("fs");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `AB\nABB`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let s = input().split("");
let t = input().split("");
while (s.length !== t.length) {
        if (t.pop() === 'B') t.reverse();
}
console.log(s.join("") === t.join("") ? 1 : 0);
