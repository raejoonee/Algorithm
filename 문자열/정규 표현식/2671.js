const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `10010111
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const regex = /^(100+1+|01)+$/g;
let submarine = input();
submarine.match(regex) == submarine ? console.log('SUBMARINE') : console.log('NOISE');
