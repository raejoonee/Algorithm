function solution(priorities, location) {
    let priority = 9;
    let answer = 0;
    let curLocation = 0;
    while (priority) {
        if (!priorities.includes(priority)) priority--;
        else if (!priorities.includes(priority, curLocation)) curLocation = 0;
        else {
            curLocation = priorities.indexOf(priority, curLocation);
            answer++;
            if (curLocation === location) return answer;
            priorities[curLocation] = 0;
        }
    }
    return -1;
}
