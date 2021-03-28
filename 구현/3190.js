const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `input
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const N = parseInt(input());
const K = parseInt(input());
// 0: 빈 땅, 1: 뱀이 있는 땅, 2: 사과가 있는 땅
let map = Array.from(new Array(N), () => new Array(N).fill(0));
for (let i = 0; i < K; i++) {
    let [x, y] = input().split(" ").map(Number);
    map[x-1][y-1] = 2;
}
const L = parseInt(input());
let move = [];
for (let i = 0; i < L; i++) move.push(input().split(" "));
const direction = [[0, 1], [1, 0], [0, -1], [-1, 0]];
let tail = [[0, 0]]; // 꼬리가 될 위치들이 Queue에 저장

let x = 0;
let y = 0;
let way = 0;
let time = 0;
while (true) {
    if (map[x] === undefined) break;
    if (map[x][y] === undefined || map[x][y] === 1) break;
    switch(map[x][y]) {
        case 0: // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
            let curTail = tail.shift();
            map[curTail[0]][curTail[1]] = 0;
        case 2: // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            map[x][y] = 1;
            tail.push([x, y]);
    }

    // 방향 전환
    if (move.length) {
        if (move[0][0] == time) {
            if (move[0][1] === 'L') way--;
            else way++;
            move.shift();
        }
    }
    if (way === -1) way = 3;
    else if (way === 4) way = 0;

    // 다음으로 이동할 좌표 구하기
    let newX = x + direction[way][0];
    let newY = y + direction[way][1];
    x = newX;
    y = newY;
    time++;
}

console.log(time);
