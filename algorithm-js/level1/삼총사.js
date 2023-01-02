function solution(number) {
    number.sort((a, b) => a - b);
    let answer = 0;
    const recursive = (lastIndex, sum, step) => {
        if (step > 2) {
            if (sum === 0) {
                answer++;
            }
        } else if (sum <= 0) {
            for (let i = lastIndex + 1; i < number.length; i++) {
                recursive(i, sum + number[i], step + 1);
            }
        }
    }
    recursive(-1, 0, 0)
    return answer;
}

