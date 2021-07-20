function solution(cacheSize, cities) {
    if (!cacheSize) return 5 * cities.length; // 캐시 크기가 0이면 무조건 cache miss
    
    let time = 0; // 실행 시간
    let cache = new Array(cacheSize); // 캐시

    cities.forEach(city => {
        city = city.toLowerCase(); // 대소문자 구분이 없으므로 전부 소문자로 변환
        
        // 캐시에 도시가 있을 경우
        if (cache.includes(city)) {
            time++; // 실행 시간 1초
            // LRU 알고리즘을 사용해서 캐시 교체
            let front = cache.slice(0, cache.indexOf(city));
            let back = cache.slice(cache.indexOf(city)+1);
            cache = front.concat(back);
            cache.push(city);
        } 
        // 캐시에 도시가 없을 경우
        else {
            time += 5; // 실행 시간 5초
            // LRU 알고리즘을 사용해서 캐시 교체
            cache.shift();
            cache.push(city);
        }
    });
    
    return time;
}
