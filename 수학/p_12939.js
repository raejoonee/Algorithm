function solution(s) {
    let ans = s.split(' ');
    ans.sort((a, b) => a-b);
    return '' + ans[0] + ' ' + ans[ans.length-1];
}
