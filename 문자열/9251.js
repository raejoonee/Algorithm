const fs = require("fs");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `ACAYKP
CAPCAK`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let A = input();
let B = input();
let aLength = A.length;
let bLength = B.length;
let lcs = Array.from(Array(aLength+1), () => Array(bLength+1).fill(0));

for (let i = 1; i <= aLength; i++) {
    for (let j = 1; j <= bLength; j++) {
        if (A[i-1] === B[j-1]) lcs[i][j] = lcs[i-1][j-1] + 1;
        else lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
    }
}

console.log(lcs[aLength][bLength]);
