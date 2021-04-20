function solution(s){
    let openTime = 0;
    let openStatus = false;
    for (let i = 0; i < s.length; i++){
        if (openTime <= 0 && s[i] == ')') return false;
        if (s[i] == '('){
            openStatus = true;
            openTime++;
        } else {
            openStatus = false;
            openTime--;
        }
    }
    if (openTime != 0) return false;
    return true;
}
