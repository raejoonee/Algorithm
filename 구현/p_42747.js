function solution(citations) {
    let answer = 0;
    let counter = -1;
    while (counter++ <= 10000) {
        let cited = 0;
        for (let citation of citations) {
            if (cited >= counter) break;
            if (citation >= counter) cited++;
        }
        if (cited < counter) {
            answer = counter-1;
            break;
        }
    }
    
    return answer;
}
