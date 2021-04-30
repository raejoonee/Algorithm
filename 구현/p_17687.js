function solution(n, t, m, p) {
    let ans = '';
    let tmp = '';
    for (let i = 0; i < t*m; i++){
        tmp += i.toString(n);
    }
    for (let i = 0; i < tmp.length; i++){
        if (ans.length === t) break;
        if (i % m === p - 1) ans += tmp[i];
    }
    return ans.toUpperCase();
}
