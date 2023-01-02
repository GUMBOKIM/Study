function solution(k, m, score) {
    score.sort((a, b) => b - a);
    let answer = 0;
    for (let i = 1; i <= score.length / m; i++) {
        console.log(i * m - 1);
        answer += score[i * m - 1] * m
    }
    return answer;
}