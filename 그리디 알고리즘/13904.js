const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `7
4 60
4 40
1 20
2 50
3 30
4 10
6 5
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

class Assignment {
    constructor(due, point) {
        this.due = due;
        this.point = point;
    }
}

const N = parseInt(input());
let queue = [];
let maxDue = -Infinity;
for (let i = 0; i < N; i++) {
    const [d, w] = input().split(" ").map(Number);
    if (d > maxDue) maxDue = d;
    queue.push(new Assignment(d, w));
}
queue.sort((a, b) => {
    if (a.due === b.due) return b.point - a.point;
    return a.due - b.due;
});
let window = [];
let answer = 0;
while (queue.length || maxDue) {
    if (queue.length) {
        while (queue[queue.length-1].due === maxDue) {
            window.push(queue.pop().point);
            if (!queue.length) break;
        }
    }
    window.sort((a, b) => a - b);
    // console.log(queue, window, answer);
    if (window.length) answer += window.pop();
    maxDue--;
}
console.log(answer);
