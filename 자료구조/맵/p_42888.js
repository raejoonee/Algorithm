function solution(record) {
    let map = new Map(); // 유저 아이디와 닉네임을 매칭할 map
    let answer = [];
    
    // 아이디 설정하기
    record.forEach(e => {
        let info = e.split(' ');
        switch(info[0][0]) {
            case 'E':
            case 'C':
                map.set(info[1], info[2]);
        }
    });
    
    // 로그 만들기
    record.forEach(e => {
        let info = e.split(' ');
        switch (info[0][0]) {
            case 'E':
                answer.push(`${map.get(info[1])}님이 들어왔습니다.`);
                break;
            case 'L':
                answer.push(`${map.get(info[1])}님이 나갔습니다.`);
                break;
        }
    });
    
    return answer;
    
}
