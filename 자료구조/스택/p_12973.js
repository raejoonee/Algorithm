function solution(s) {
    let stack = [];
    for (let letter of s) {
        let pop = stack.pop();
        if (pop !== letter) {
            if (pop !== undefined) stack.push(pop);
            stack.push(letter);
        }
    }
    return stack.length === 0 ? 1 : 0;
}
