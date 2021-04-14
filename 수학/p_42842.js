function solution(brown, yellow) {
    let answer = [];
    for (let b = 1; b <= yellow; b++) {
        let a = yellow/b;
        if (a%1==0) {
            if (2*(a+b)+4 == brown) {
                answer[0] = a+2;
                answer[1] = b+2;
                break;
            }
        }
    }
    
    return answer;
}
