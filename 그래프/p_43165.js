function solution(numbers, target) {
    let answer = 0;
    
    const dfs = (index, curVal, sign) => {
        if (index === numbers.length) {
            if (curVal === target) answer++;
            return ;
        }
        
        if (sign) {
            dfs(index+1, curVal+numbers[index], true);
            dfs(index+1, curVal+numbers[index], false);
        } else {
            dfs(index+1, curVal-numbers[index], true);
            dfs(index+1, curVal-numbers[index], false);
        }
        
    }
    
    dfs(0, 0, true);
    dfs(0, 0, false);
    
    return answer/2;
}
