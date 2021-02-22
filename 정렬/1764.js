const fs = require("fs");
const { setPriority } = require("os");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `3 4
ohhenrie
charlie
baesangwook
ohhenrie
charlie
baesangwook
clinton`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(e => parseInt(e));
let set = new Set();
for (let i = 0; i < N; i++) {
    set.add(input());
}
let answer = [];
for (let i = 0; i < N; i++) {
    let noSeen = input();
    if (set.has(noSeen)) {
        answer.push(noSeen);
    }
}
answer.sort();
console.log(answer.length);
answer.forEach(e => console.log(e));
