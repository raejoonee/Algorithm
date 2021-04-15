function solution(people, limit) {
    let answer = 0;
    people.sort((a,b)=>b-a);
    let left = 0;
    let right = people.length-1;
    while (true) {
        if (left > right) break;
        answer++;
        if (people[left] + people[right] <= limit) {
            left++;
            right--;
        } else {
            left++;
        }
    }
    return answer;
}
