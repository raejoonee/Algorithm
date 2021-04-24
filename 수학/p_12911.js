function findOne(s){
    let a = 0;
    for (let i = 0; i < s.length; i++){
        if (s[i] === '1') a++;
    }
    return a;
}

function solution(n) {
    let ones = findOne(n.toString(2));
    let ans = n+1;
    while (true) {
        if (findOne(ans.toString(2)) === ones) return ans;
        ans++;
        if (ans === 1000000) break;
    }
    return 1000000;
}
