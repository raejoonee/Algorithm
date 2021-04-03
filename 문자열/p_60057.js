function solution(s) {
    let answer = s.length;
    // 자르는 단위를 1부터 s.length의 반까지 늘리면서 완전 탐색
    for (let unit = 1; unit <= parseInt(s.length/2); unit++) {
        // 각 경우 압축된 문자의 길이
        let curLength = s.length;
        // console.log(`unit is ${unit} and curLength is ${curLength}`)
        for (let curPos = 0; curPos < s.length; ) {
            let count = 1;
            let target = s.slice(curPos, curPos+unit);
            // console.log(`target is ${target}`)
            curPos += unit;
            while (s.slice(curPos, curPos+unit) === target) {
                curLength -= unit;
                curPos += unit;
                count++;
                // console.log('collected!')
            }
            // console.log(`count is ${count}, curLength is ${curLength}`)
            if (count !== 1) curLength+=parseInt(Math.log10(count)+1);
            
        }
        // console.log(`my unit is ${unit}, and my curLength is ${curLength}`);
        if (curLength < answer) answer = curLength;
    }
    
    
    return answer;
}
