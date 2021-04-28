function solution(s) {
    let arr = s.split(' ');
    let ans = [];
    for (let i = 0; i < arr.length; i++){
        ans.push(arr[i].slice(0, 1).toUpperCase().concat(arr[i].slice(1).toLowerCase()));
    }
    return ans.join(' ');
}
