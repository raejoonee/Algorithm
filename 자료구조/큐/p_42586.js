function solution(progresses, speeds) {
    let answer = [];
    while (progresses.length) {
        for (let pgr in progresses) progresses[pgr] += speeds[pgr];
        let cnt = 0;
        while (progresses[0] >= 100) {
            progresses.shift();
            speeds.shift();
            cnt++;
        }
        if (cnt) answer.push(cnt);
    }
    return answer;
}