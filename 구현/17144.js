const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `7 8 50
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let [R, C, T] = input().split(" ").map(Number);
let room = [];
for (let i = 0; i < R; i++)
    room[i] = input().split(" ").map(Number);

// 미세먼지 확산
const diffuse = () => {
    let temp = Array.from(new Array(R), () => new Array(C).fill(0));
    for (let i = 0; i < R; i++) {
        for (let j = 0; j < C; j++) {
            if (room[i][j] === -1) continue;
            if (room[i][j] !== 0) {
                let quotient = parseInt(room[i][j] / 5);
                if (i > 0) {
                    if (room[i-1][j] !== -1) {
                        temp[i][j] -= quotient;
                        temp[i-1][j] += quotient;
                    }
                }
                if (i < R-1) {
                    if (room[i+1][j] !== -1) {
                        temp[i][j] -= quotient;
                        temp[i+1][j] += quotient;
                    }
                }
                if (j > 0) {
                    if (room[i][j-1] !== -1) {
                        temp[i][j] -= quotient;
                        temp[i][j-1] += quotient;
                    }
                }
                if (j < C-1) {
                    if (room[i][j+1] !== -1) {
                        temp[i][j] -= quotient;
                        temp[i][j+1] += quotient;
                    }
                }
            }
        }
    }
    for (let i = 0; i < R; i++) {
        for (let j = 0; j < C; j++) {
            room[i][j] += temp[i][j];
        }
    }
}

// 위쪽 공기청정기 작동
const cleanUp = row => {
    let column = 1;
    let newWind = 0;
    let oldWind = 0;
    // 오른쪽으로 바람 이동
    while (column < C) {
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
        column++;
    }
    column--;
    // 위쪽으로 바람 이동
    while (row >= 1) {
        row--;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    // 왼쪽으로 바람 이동
    while (column >= 1) {
        column--;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    // 아래쪽으로 바람 이동
    while (true) {
        row++;
        if (room[row][column] === -1) break;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    return ;
}

// 아래쪽 공기청정기 작동
const cleanDown = row => {
    let column = 1;
    let newWind = 0;
    let oldWind = 0;
    // 오른쪽으로 바람 이동
    while (column < C) {
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
        column++;
    }
    column--;
    // 아래쪽으로 바람 이동
    while (row < R-1) {
        row++;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    // 왼쪽으로 바람 이동
    while (column >= 1) {
        column--;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    // 위쪽으로 바람 이동
    while (true) {
        row--;
        if (room[row][column] === -1) break;
        newWind = oldWind;
        oldWind = room[row][column];
        room[row][column] = newWind;
    }
    return ;
}

// index: 위쪽 공기청정기의 row index
let index = 0;
for (let i = 0; i < R; i++) {
    if (room[i][0] !== -1) continue;
    index = i;
    break;
}

while (T--) {
    diffuse(); // 미세먼지 확산
    cleanUp(index); // 위쪽 공기청정기 작동
    cleanDown(index+1); // 아래쪽 공기청정기 작동
}

let answer = 0;
for (let i = 0; i < R; i++)
    for (let j = 0; j < C; j++)
        if (room[i][j] !== -1) answer += room[i][j];
console.log(answer);
