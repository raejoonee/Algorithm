const fs = require("fs");
const stdin = (process.platform === "linux" ?
        fs
        .readFileSync("/dev/stdin")
        .toString()
        .trim() :
        `2019`
).split("\n");

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let target = +input();
const calculate = a => {
        let answer = 0;
        for (let i = 0; i < a.length; i++) {
                answer += +a[i];
        }
        return answer + +a;
};

let set = new Set();
set.add(target);
let curNum = target;
while (curNum--) {
        if (set.has(calculate(curNum + ""))) set.add(curNum);
}
console.log(set.size);