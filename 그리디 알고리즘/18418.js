const fs = require("fs");
const stdin = (process.platform === "linux" ?
        fs
        .readFileSync("/dev/stdin")
        .toString()
        .trim() :
        ``
).split("\n");

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

class Strawberry {
        constructor(A, N) {
                this.A = A;
                this.N = N;
        }
}

let N = input();
let strawberryList = [];
for (i = 0; i < N; i++) {
        let [A, N] = input().split(" ").map(e => parseInt(e));
        strawberryList.push(new Strawberry(A, N));
}
strawberryList.sort((a, b) => b.A - a.A);
let answer = strawberryList[0].A;
for (let strawberry in strawberryList) {
        while (answer < strawberryList[+strawberry].N) answer++;
        if (+strawberry === strawberryList.length - 1) break;
        answer += strawberryList[+strawberry].A - strawberryList[+strawberry + 1].A;
}
answer += strawberryList.pop().A;
console.log(answer);