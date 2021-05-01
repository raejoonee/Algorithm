function solution(n,a,b){
    let times = 0;
    while (times !== n){
        a = a % 2 === 1 ? (a+1)/2 : a/2;
        b = b % 2 === 1 ? (b+1)/2 : b/2;
        times++;
        if (a === b) break;
    }
    return times;
}
