function solution(A) {
    let answer = Infinity;
    let left = 0;
    let right = A.reduce((pre, cur) => pre + cur);
    A.forEach(num => {
        left += num;
        right -= num;
        answer = Math.min(answer, Math.abs(left-right));
    });
    return answer;
}
