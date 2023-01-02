function solution(k, score) {
    const answer = [];

    const hallOfFame = [];
    for (let i = 0; i < score.length; i++) {
        const nowScore = Number(score[i]);
        addHallOfFame(hallOfFame, k, nowScore);
        answer.push(hallOfFame[hallOfFame.length - 1]);
    }
    return answer;
}

const addHallOfFame = (hallOfFame, k, score) => {
    if (hallOfFame.length < k) {
        hallOfFame.push(score);
        hallOfFame.sort((a, b) => b - a);
    } else {
        if (hallOfFame[k - 1] < score) {
            hallOfFame.pop();
            hallOfFame.push(score);
            hallOfFame.sort((a, b) => b - a);
        }
    }
}

console.log(solution(3, [10, 100, 20, 150, 1, 100, 200]))