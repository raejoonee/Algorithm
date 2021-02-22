const fs = require("fs");
const { setPriority } = require("os");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `16 4
noj.am IU
acmicpc.net UAENA
startlink.io THEKINGOD
google.com ZEZE
nate.com VOICEMAIL
naver.com REDQUEEN
daum.net MODERNTIMES
utube.com BLACKOUT
zum.com LASTFANTASY
dreamwiz.com RAINDROP
hanyang.ac.kr SOMEDAY
dhlottery.co.kr BOO
duksoo.hs.kr HAVANA
hanyang-u.ms.kr OBLIVIATE
yd.es.kr LOVEATTACK
mcc.hanyang.ac.kr ADREAMER
startlink.io
acmicpc.net
noj.am
mcc.hanyang.ac.krn`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(e => parseInt(e));
let map = new Map();
for (let i = 0; i < N; i++) {
    const [site, pw] = input().split(" ");
    map.set(site, pw);
}
for (let i = 0; i < M; i++) {
    console.log(map.get(input()));
}
