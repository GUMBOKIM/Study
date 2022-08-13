function solution(people, limit) {
    let length = people.length
    people.sort((a1, a2) => a2 - a1)

    let start = 0;
    let end = length - 1;

    let answer = 0;
    while(start < end) {
        if(people[start] + people[end] <= limit) {
            end --;
        }
        start ++;
        answer ++;
    }
    return answer;
}

console.log(solution([70, 50, 80, 50], 100))