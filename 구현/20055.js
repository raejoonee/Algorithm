const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `5 8
100 99 60 80 30 20 10 89 99 100
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [N, K] = input().split(" ").map(Number);
let A = input().split(" ").map(Number);
let robot = []; // 로봇들의 현재 위치
let zeroCount = 0; // 내구도가 0인 칸의 개수
let time = 0; // 정답
// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
while (zeroCount < K) {
    time++;
    // 1. 벨트가 한 칸 회전한다. (벨트도 이동하고, 위에 있는 로봇도 이동한다.)
    A.unshift(A.pop());
    robot.forEach((e, i) => {
        robot[i]++;
    });
    // 내려가는 위치에 가장 먼저 벨트에 올라간 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다.
    while (robot[0] >= N-1) robot.shift();
    // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
    robot.forEach((e, i) => {
        // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
        if (A[e+1] > 0 && !robot.includes(e+1)) {
            A[e+1]--;
            if (A[e+1] === 0) zeroCount++;
            robot[i]++;
        }
    });
    // 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
    if (A[0] > 0 && !robot.includes(0)) {
        robot.push(0);
        A[0]--;
        if (A[0] === 0) zeroCount++;
    }
}
console.log(time);
