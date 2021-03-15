const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `8
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const N = +input();
let chessBoard = [];
let answer = 0;

const possible = idx => {
    for (let i = 0; i < idx; i++) if (chessBoard[i] === chessBoard[idx] || idx-i === Math.abs(chessBoard[i] - chessBoard[idx])) return false;
    return true;
}

const dfs = idx => {
    if (idx === N) answer++;
    else {
        for (let i = 0; i < N; i++) {
            chessBoard[idx] = i;
            if (possible(idx)) dfs(idx+1);
        }
    }
}

dfs(0);
console.log(answer);
