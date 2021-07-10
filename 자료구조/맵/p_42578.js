function solution(clothes) {
    let map = new Map();
    for (let clothInfo of clothes) {
        map.get(clothInfo[1]) ? map.set(clothInfo[1], map.get(clothInfo[1]).concat(clothInfo[0])) : map.set(clothInfo[1], [clothInfo[0]]);
    }
    let arr = Array.from(map);
    if (arr.length === 1) return arr[0][1].length;
    let answer = 1;
    arr.forEach(e => {
        answer *= e[1].length+1;
    });
    return answer-1;
}
