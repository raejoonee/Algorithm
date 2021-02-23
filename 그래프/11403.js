const fs = require("fs");
const { setPriority } = require("os");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `7
0 0 0 1 0 0 0
0 0 0 0 0 0 1
0 0 0 0 0 0 0
0 0 0 0 1 1 0
1 0 0 0 0 0 0
0 0 0 0 0 0 1
0 0 1 0 0 0 0`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

const N = parseInt(input());
let arr = [];
for (let i = 0; i < N; i++) {
    arr[i] = [];
    input().split(" ").forEach((v, index) => {
        if (v === '1') arr[i].push(index);
    });
}
const find = (x, y) => {
    let queue = [];
    let visited = [];
    queue.push(x);
    while (queue.length) {
        let curIdx = queue.shift();
        let curArr = arr[curIdx];
        for (let i = 0; i < curArr.length; i++) {
            if (curArr[i] === y) return true;
            if (!visited[curArr[i]]) {
                queue.push(curArr[i]);
                visited[curArr[i]] = true;
            }
        }
    }
    return false;
}
for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        let answer = find(i, j) ? 1 : 0;
        process.stdout.write(`${answer} `);
    }
    console.log();
}
