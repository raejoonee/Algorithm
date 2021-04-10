function solution(name) {
    let arr = [];
    let answer = 0;
    name.split("").forEach(e => {
        let time = e.charCodeAt(0)-65;
        if (time > 13) time = 26-time;
        arr.push(time);
    });
    let length = arr.length;
    answer = arr.reduce((pre, cur) => pre + cur);
    answer += length-1;
    // 조이스틱을 왼쪽으로 이동하는 경우
    let temp = answer;
    for (let i = 1; i < length; i++) {
        if (arr[i] != 0) break;
        temp--;
    }
    // 조이스틱을 오른쪽으로 이동하는 경우
    let temp2 = answer;
    for (let i = length-1; i > 0; i--) {
        if (arr[i] != 0) break;
        temp2--;
    }
    // 조이스틱을 오른쪽으로 이동한 뒤 왼쪽으로 이동하는 경우
    let temp3 = answer;
    let idx = 0;
    let curCount = 0;
    let count = 0;
    for (let i = 1; i < length; i++) {
        if (arr[i] != 0) {
            count = 0;
            continue;
        }
        count++;
        if (curCount < count) {
            idx = i;
            curCount = count;
        }
    }
    temp3 -= length-1;
    temp3 += (idx-curCount)*2;
    temp3 += length-idx-1;
    // 두 경우 중 더 작은 경우가 조작 횟수가 최소가 된다.
    answer = Math.min(temp, temp2, temp3);
    return answer;
}
