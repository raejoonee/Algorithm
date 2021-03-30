const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `4
aba
abab
abcabc
a
`
)
.trim()
.split("\n");

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

// 그룹 단어인지 확인하는 함수
const verify = str => {
    let length = str.length;
    let info = [];
    let char = '';
    for (let i = 0; i < length; i++) {
        if (info[str[i]]) {
            if (char !== str[i]) return 0;
        } else info[str[i]] = true;
        char = str[i];
    }
    return 1;
}

const N = parseInt(input());
let answer = 0;
for (let i = 0; i < N; i++) answer += verify(input());
console.log(answer);
