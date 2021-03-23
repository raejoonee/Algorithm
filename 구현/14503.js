const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

// input
let room = []; // 0: dirty, 1: wall, 2: clean
const [N, M] = input().split(" ").map(Number);
const [r, c, d] = input().split(" ").map(Number);
for (let i = 0; i < N; i++) room[i] = input().split(" ").map(Number);
let visited = Array.from(new Array(N), () => new Array(M).fill(false));
const move = [[-1, 0], [0, 1], [1, 0], [0, -1]];

// output
let answer = 0;

// 네 방향 모두 청소가 되어있는지 확인 (recursive)
// **왼쪽 방향부터 확인해서** 청소 안 된 방향이 있다면 해당 방향 정보를 반환
// 모든 방향이 청소가 된 상태라면 -1을 반환
function cleanCheck(x, y, direction, depth) {
    if (depth === 4) return -1;
    if (direction === 0) direction = 3;
    else direction--;
    let newX = x + move[direction][0];
    let newY = y + move[direction][1];
    if (room[newX] !== undefined) {
        if (room[newX][newY] === 0) return direction;
    }
    return cleanCheck(x, y, direction, depth + 1);
}

function clean(x, y, direction) {
    visited[x][y] = true;
    if (room[x][y] === 0) answer++; // 청소하지 않은 위치에 도착할 경우 정답 + 1
    room[x][y] = 2; // 1. 현재 위치를 청소한다.
    let info = cleanCheck(x, y, direction, 0); // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색을 진행한다.

    // 네 방향 모두 청소가 되어 있거나 벽인 경우
    if (info === -1) {
        let back = direction < 2 ? direction + 2 : direction - 2;
        let newX = x + move[back][0];
        let newY = y + move[back][1];
        if (room[newX][newY] === 1) return ; // 뒤쪽 방향이 벽인 경우 작동을 멈춘다.
        else clean(newX, newY, direction); // 아닐 경우 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
    }
    // 왼쪽 방향에 아직 청소하지 않은 공간이 존재하는 경우
    else clean(x + move[info][0], y + move[info][1], info);
}

clean(r, c, d);
console.log(answer);
