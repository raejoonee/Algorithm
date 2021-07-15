function solution(n, words) {
    let answer = []; // 정답
    let currentPerson = 0; // 현재 번호
    let currentOrder = 1; // 현재 차례
    let stack = []; // 현재까지 등장한 단어 목록
    let endAlphabet = ''; // 앞서 나온 단어의 끝말
    
    for (let i = 0; i < words.length; i++) {
        // [번호, 차례] 변경하기
        currentPerson++;
        if (currentPerson > n) {
            currentPerson = 1;
            currentOrder++;
        }
        
        // 현재 단어가 이전에 등장한 단어인지 확인
        if (stack.includes(words[i])) {
            answer.push(currentPerson, currentOrder);
            break;
        }
        
        // 현재 단어가 끝말잇기가 되는지 확인
        if (endAlphabet === '' || endAlphabet === words[i][0]) {
            stack.push(words[i]);
            endAlphabet = words[i][words[i].length-1];
        } else {
            answer.push(currentPerson, currentOrder);
            break;
        }
        
    }
    
    // 위 과정에서 탈락자가 생기지 않는다면, [0, 0]을 반환
    if (!answer.length) return [0, 0];
    
    return answer;
}
