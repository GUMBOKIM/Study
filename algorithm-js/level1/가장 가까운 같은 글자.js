function solution(s) {
    const answer = [];
    const map = new Map();
    for (let i = 0; i < s.length; i++) {
        const now = s.at(i);
        answer.push(map.has(now) ? i - map.get(now) : -1);
        map.set(now, i);
    }
    return answer;
}
