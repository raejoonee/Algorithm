function solution(A) {
    A.sort((a, b) => a - b);
    for (let idx in A) if (+idx + 1 !== A[idx]) return +idx + 1;
    return A.length+1;
}
