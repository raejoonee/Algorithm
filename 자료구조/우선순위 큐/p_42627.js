function solution(jobs) {
    // 요청 시간에 따라 정렬
    jobs.sort((a, b) => a[0] - b[0]);
    let jobCount = jobs.length;
    // 요청 상태인 작업을 담을 큐
    let waitQueue = [];
    // 요청부터 종료까지 걸린 시간을 담을 배열
    let timeList = [];
    // 현재 시간
    let time = 0;
    while (waitQueue.length || jobs.length) {
        // 매 초마다 요청을 한 작업이 있는지 찾아서 전부 waitQueue에 삽입
        if (jobs.length) {
            while (time >= jobs[0][0]) {
                if (jobs.length) waitQueue.push(jobs.shift());
                if (!jobs.length) break;
            }
        }
        // 요청한 작업이 없을 경우, 아직 요청 전인 작업이 있다는 뜻이므로 시간만 늘림
        if (!waitQueue.length) {
            time++;
            continue;
        }
        // waitQueue를 최대한 빨리 끝나는 작업 순으로 재배치
        // js가 아니었다면, PriorityQueue를 써서 생략 가능
        waitQueue.sort((a, b) => a[1] - b[1]);
        // 모든 waitQueue의 작업들에 대해 (종료 시간 - 요청 시간)을 timeList에 담음
        if (waitQueue.length) {
            const [jobIndex, jobTime] = waitQueue.shift();
            time += jobTime;
            timeList.push(time - jobIndex);
        }
    }
    // timeList 배열을 reduce()하고 jobCount로 나눈 다음 소숫점 버림
    return Math.floor(timeList.reduce((pre, cur) => pre + cur) / jobCount);
}
