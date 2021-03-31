function solution(n) {
    let answer = '';
    const rule = "412";
    while (n) {
        answer = rule[n%3] + answer;
        n = n % 3 ? n/3 : parseInt(n/3)-1;
    }
    return answer;
}
