const fs = require("fs");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `4
5
3
7
5`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let N = parseInt(input());
let pointList = [];
for (let i = 0; i < N; i++) {
    pointList[i] = parseInt(input());
}
let answer = 0;
for (let i = N-1; i >= 0; i--) {
    while (pointList[i-1] >= pointList[i]) {
        pointList[i-1]--;
        answer++;
    }
}
console.log(answer);
