function solution(n, edge) {
    let arr = [];
    edge.forEach(node => {
        if (arr[node[0]] === undefined) arr[node[0]] = [];
        if (arr[node[1]] === undefined) arr[node[1]] = [];
        arr[node[0]].push(node[1]);
        arr[node[1]].push(node[0]);
    })
    let distance = [];
    let visited = [];
    let queue = [];
    queue.push(1);
    visited[1] = true;
    distance[1] = 1;
    while (queue.length) {
        let shifted = queue.shift();
        arr[shifted].forEach(e => {
            if (!visited[e]) {
                queue.push(e);
                visited[e] = true;
                distance[e] = distance[shifted] + 1;
            }
        });
    }
    let answer = 0;
    let max = 1;
    distance.forEach (e => {
        if (e > max) {
            max = e;
            answer = 0;
        }
        if (e === max) answer++;
    })
    return answer;
}
