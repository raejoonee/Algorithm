function count(time, traffics, curCount) {
    if (time < 0) curCount++;
    let idx = traffics.indexOf(time);
    while (idx++) {
        if (idx > traffics.length) break;
        if (Math.abs(traffics[idx]) - Math.abs(time) >= 1000) break;
        if (traffics[idx] * time > 0) continue;
        if (traffics[idx] > 0) curCount++;
        if (traffics[idx] === time) curCount++;
    }
    return curCount;
}

function solution(lines) {
    let answer = 0;
    let traffics = [];
    let curCount = 0;
    lines.forEach(str => {
        let finishedTime = new Date(str.slice(0, 23));
        let gap = +str.slice(24).replace('s','') * 1000 - 1;
        traffics.push(finishedTime - 0 - gap); // start
        traffics.push((finishedTime - 0) * -1); // end
    });
    traffics.sort((a, b) => Math.abs(a) - Math.abs(b));
    traffics.forEach(time => {
        if (time > 0) curCount++;
        else curCount--;
        answer = Math.max(answer, count(time, traffics, curCount));
    });
    return answer;
}
