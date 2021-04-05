const gcd = (a, b) => {
    let c;
    while (b) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

function solution(w, h) {
    return w * h - (w + h) + gcd(w, h);
}
