const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `3
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const solution = e => {
    if (e === 1) return 0;
    let answer = 0;
    for (let i = Math.pow(3, e-1); i < Math.pow(3, e); i++) {
        let sum = i.toString(3).split("").map(Number).reduce((a, b) => a + b, 0);
        if (sum % 3 === 0) answer++;
    }
    return answer;
}
console.log(solution(+input()));
