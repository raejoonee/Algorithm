function solution(n) {
    let answer = 0;
    let temp = 0;
    for (let i = 1; i <= n; i++) {
        temp = i;
        for (let j = i + 1; j <= n + 1; j++) {
            if (temp > n) break;
            if (temp === n) {
                answer++;
                break;
            }
            temp += j;
        }
    }
    return answer;
}
