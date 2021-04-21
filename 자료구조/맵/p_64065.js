function solution(s) {
    let a = s.replace(/{/g, '').replace(/}/g, '').replace(/ /g, '').split(',');
    let temp = new Map();
    for (let i = 0; i < a.length; i++){
        if (!temp.has(+a[i])) temp.set(+a[i], 1);
        else temp.set(+a[i], temp.get(+a[i])+1);
    }
    let answer = [];
    for (let [key, value] of temp){
        answer.push([value, +key]);
    }
    return answer.sort((a, b) => a[0] - b[0]).map(a => a[1]).reverse();
}
