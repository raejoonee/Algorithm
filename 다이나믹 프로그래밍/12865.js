const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `4 7
6 13
4 8
3 6
5 12
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, K] = input().split(" ").map(Number);
let itemList = [];
for (let i = 1; i <= N; i++) {
    const [W, V] = input().split(" ").map(Number);
    let item = {
        weight: W,
        value: V
    };
    itemList[i] = item;
}
let dp = new Array(N+1).fill([]);
for (let index in dp) dp[+index] = new Array(K+1).fill(0);
for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= K; j++) {
        if (j >= itemList[i].weight) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-itemList[i].weight] + itemList[i].value);
        else dp[i][j] = dp[i-1][j];
    }
}
console.log(dp[N][K]);
