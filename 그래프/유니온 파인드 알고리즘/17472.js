const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `7 7
1 1 1 0 1 1 1
1 1 1 0 1 1 1
1 1 1 0 1 1 1
0 0 0 0 0 0 0
1 1 1 0 1 1 1
1 1 1 0 1 1 1
1 1 1 0 1 1 1
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

// init settings & input
const [N, M] = input().split(" ").map(Number);
let map = Array.from(new Array(N), () => new Array(M));
let visited = Array.from(new Array(N), () => new Array(M).fill(false));
for (let i = 0; i < N; i++) {
    map[i] = input().split(" ").map(Number);
}
let parent = new Array(7);
// console.log(map);

let answer = [];

// Bridge class
class Bridge {
    constructor(start, end, length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

// direction indicators for searching
let direction = [[0, 1], [0, -1], [1, 0], [-1, 0]];

// composing islands
const composeIslands = (x, y, value) => {
    visited[x][y] = true;
    map[x][y] = value;
    for (let i = 0; i < 4; i++) {
        let newX = x + direction[i][0];
        let newY = y + direction[i][1];
        if (0 > newX || newX >= N || 0 > newY || newY >= M) continue;
        if (map[newX][newY] == undefined) continue;
        if (!map[newX][newY]) continue;
        if (!visited[newX][newY]) composeIslands(newX, newY, value);
    }
}

// building bridges
const buildBridge = (x, y, value) => {
    for (let i = 0; i < 4; i++) {
        let newX = x;
        let newY = y;
        let length = 0;
        while (true) {
            newX += direction[i][0];
            newY += direction[i][1];
            if (0 > newX || newX >= N || 0 > newY || newY >= M) break;
            if (map[newX][newY] == undefined) break;
            if (!map[newX][newY]) {
                length++;
                continue;
            }
            if (map[newX][newY]) { 
                // when len is 1 or below 1, it can't be a bridge.
                if (length > 1) {
                    answer.push(new Bridge(value, map[newX][newY], length));
                    break;
                }
                break;
            }
        }
    }
}

// find for Union-Find Algorithm
const find = x => {
    if (parent[x] === x) return x;
    return find(parent[x]);
}

// union for Union-Find Algorithm
const union = (a, b) => {
    let findA = find(a);
    let findB = find(b);
    if (findA < findB) parent[findB] = findA;
    else parent[findA] = findB;
}

// available checker
const available = (x, y) => {
    for (let i = 0; i < 4; i++) {
        let newX = x + direction[i][0];
        let newY = y + direction[i][1];
        if (0 > newX || newX >= N || 0 > newY || newY >= M) continue;
        if (map[newX][newY] == undefined) continue;
        if (!map[newX][newY]) return true;
    }
    return false;
}

// solution
let dap = 0;
let counter = 0;
for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j]) {
            counter++;
            composeIslands(i, j, counter);
        }
    }
}
for (let i = 1; i <= counter; i++) parent[i] = i;
for (let i = 0; i < N; i++)
    for (let j = 0; j < M; j++)
        if (map[i][j] && available(i, j)) buildBridge(i, j, map[i][j]);
answer.sort((a, b) => a.length - b.length);
for (let i = 0; i < answer.length; i++) {
    if (find(answer[i].start) != find(answer[i].end)) {
        dap += answer[i].length;
        union(answer[i].start, answer[i].end);
    }
}
let flag = true;
let curVal = find(1);
for (let i = 2; i <= counter; i++) {
    if (curVal != find(i)) {
        flag = false;
        console.log(-1);
        break;
    }
}
if (flag) console.log(dap);
