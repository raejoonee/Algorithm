const fs = require("fs");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let answer = [];
const T = parseInt(input());
for (let i = 0; i < T; i++) {
    const [M, N, K] = input().split(" ").map(e => parseInt(e));
    let cabbageField = Array.from(Array(N), () => Array(M).fill(0));
    let visited = Array.from(Array(N), () => Array(M).fill(false));
    let curAnswer = 0;
    let wormList = [];
    for (let j = 0; j < K; j++) {
        const [X, Y] = input().split(" ").map(e => parseInt(e));
        cabbageField[Y][X] = 1;
        wormList.push([Y, X]);
    }
    const dfs = (y, x) => {
        if (cabbageField[y] === undefined) return ;
        if (cabbageField[y][x] === undefined || cabbageField[y][x] === 0) return ;
        if (visited[y][x]) return ;
        visited[y][x] = true;
        dfs(y+1, x);
        dfs(y-1, x);
        dfs(y, x+1);
        dfs(y, x-1);
    }
    for (let j = 0; j < N; j++) {
        for (let k = 0; k < M; k++) {
            if (cabbageField[j][k] && !visited[j][k]) {
                dfs(j, k);
                curAnswer++;
            }
        }
    }
    answer.push(curAnswer);
}

answer.forEach(e => console.log(e));
