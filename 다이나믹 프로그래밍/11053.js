const fs = require("fs");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `8
1 2 3 4 1 2 3 7`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

let N = parseInt(input());
let arr = input().split(" ").map(Number);
let dp = [1];
for (let i = 1; i < N; i++) {
    let dpi = 0;
    for (let j = i-1; j >= 0; j--)
        if (arr[i] > arr[j])
            dpi = Math.max(dpi, dp[j]);
    dp[i] = dpi+1;
}
console.log(Math.max(...dp));
