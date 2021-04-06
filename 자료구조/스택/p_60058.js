function solution(p) {
    // 올바른 괄호 문자열인지 판별
    const isRight = (strings) => {
        let stack = [];
        let str = strings.split('').forEach(e => {
            if (e === '(') stack.push(e);
            if (e === ')') {
                if (!stack.length) return false;
                stack.pop();
            }
        });
        if (stack.length) return false;
        return true;
    }
    if (isRight(p)) return p;
    // 문제에서 제시한 과정 구현
    const process = (str) => {
        let answer = '';
        if (!str.length) return '';
        let idx = 0;
        let open = 0;
        let close = 0;
        for (let i = 0; i < str.length; i++) {
            if (str[i] === '(') open++;
            if (str[i] === ')') close++;
            if (open === close) {
                idx = i;
                break;
            }
        }
        let u = str.slice(0, idx+1);
        let v = str.slice(idx+1);
        if (isRight(u)) {
            answer += u;
            answer += process(v);
            return answer;
        } else {
            let temp = '(';
            temp += process(v);
            temp += ')';
            temp += u.slice(1, u.length-1).replace(/[(]/g, 'c').replace(/[)]/g, '(').replace(/[c]/g, ')');
            answer += temp;
            return answer;
        }
    }
    if (!p.length) return answer;
    return process(p);
}
