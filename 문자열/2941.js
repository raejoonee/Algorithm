// const fs = require("fs");
// const input = fs.readFileSync("/dev/stdin").toString().trim();

let croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];

function solution(input) {
        for (let alphabet of croatia) {
                input = input.split(alphabet).join("a");
                console.log(alphabet, input);
        }
        return input.length;
}

console.log(solution("dz=dz=z=d-z="));