function solution(n, computers) {
    let answer = 0;
    let visit = new Array(n).fill(false);
    
    const dfs = (start) => {
        visit[start] = true;
        for(let i = 0; i < n; i++) {
            if (i === start) continue;
            if (!visit[i] && computers[start][i]) dfs(i);
        }
    }
    
    for (let computer in visit) {
        if (!visit[+computer]) {
            dfs(+computer);
            answer++;
        }
    }
    return answer;
}
