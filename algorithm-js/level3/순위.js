function solution(n, results) {
    let winGraph = {};
    for (const element of results) {
        const [win, lose] = element;
        if (!winGraph[win]) winGraph[win] = [];
        winGraph[win].push(lose);
    };

    function countWin(i, checked) {
        let temp = checked;
        let answer = 0;
        if (winGraph[i]) {
            for (const loser of winGraph[i]) {
                if(!checked.has(loser)) {
                    answer ++;
                    temp.add(loser);
                    let [addCount, returnChecked] = countWin(loser, checked);
                    temp = returnChecked;
                    answer += addCount;
                }
            }
        }
        return [answer, checked];
    }

    let loseGraph = {};
    for (const element of results) {
        const [win, lose] = element;
        if (!loseGraph[lose]) loseGraph[lose] = [];
        loseGraph[lose].push(win);
    };

    function countLose(i, checked) {
        let temp = checked;
        let answer = 0;
        if (loseGraph[i]) {
            for (const winner of loseGraph[i]) {
                if(!checked.has(winner)) {
                    answer ++;
                    temp.add(winner);
                    let [addCount, returnChecked] = countLose(winner, checked);
                    temp = returnChecked;
                    answer += addCount;
                }
            }
        }
        return [answer, checked];
    }

    let answer = 0;

    for (let i = 1; i <= n; i++) {
        let winCount = countWin(i, new Set)[0];
        let loseCount = countLose(i, new Set)[0];
        if (winCount + loseCount + 1 === n) answer++;
    }


    return answer;
}

console.log(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]));
