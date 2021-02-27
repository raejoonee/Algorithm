const fs = require("fs");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

class edge {
    constructor(start, end, cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

let N = parseInt(input());
let M = parseInt(input());
let networkList = [];
let parent = [null];
for (let i = 1; i <= N; i++) parent.push(i);
const find = a => {
    if (parent[a] === a) return a;
    return find(parent[a]);
}
const union = (a, b) => {
    let maxParent = Math.max(find(a), find(b));
    let minParent = Math.min(find(a), find(b));
    parent.forEach((e, i) => {
        if (e === maxParent) parent[i] = minParent;
    });
}
for (let i = 0; i < M; i++) {
    let info = input().split(" ").map(Number);
    networkList.push(new edge(...info));
}
networkList.sort((a, b) => b.cost - a.cost);
let answer = [];
while (answer.length !== N-1) {
    let network = networkList.pop();
    if (parent[network.start] === parent[network.end]) continue;
    union(network.start, network.end);
    answer.push(network.cost);
}
console.log(answer.reduce((pre, cur) => pre + cur, 0));
