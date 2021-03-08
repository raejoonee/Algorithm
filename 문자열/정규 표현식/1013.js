const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `3
10010111
011000100110001
0110001011001
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const regex = /^((100+1+)|01)+$/g;
let N = parseInt(input());
while (N--) {
    let radioRecord = input();
    radioRecord.match(regex) == radioRecord ? console.log('YES') : console.log('NO');
}
