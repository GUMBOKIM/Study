function solution(n, m, section) {
    let answer = 0;
    while (section.length !== 0) {
        console.log(section);
        answer++;
        const end = section.pop();
        const start = end - m;
        while (section.at(-1) > start) {
            section.pop();
        }
    }
    return answer;
}