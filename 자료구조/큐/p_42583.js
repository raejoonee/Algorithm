function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    let onboard = [];
    let time = [];
    while (truck_weights.length || onboard.length) {
        if (time[0] > bridge_length) {
            time.shift();
            onboard.shift();
        }
        let curWeight = onboard.reduce((prev, cur) => prev + cur, 0);
        if (curWeight + truck_weights[0] <= weight && truck_weights.length) {
            onboard.push(truck_weights.shift());
            time.push(1);
        }
        answer++;
        time = time.map(element => element + 1);
    }
    return answer;
}
