function solution(numbers) {
    const answer = [];
    for (let i = 0; i < numbers.length; i++) {
        const number = numbers[i];
        let result = -1;
        for (let j = i + 1; j < numbers.length; j++) {
            if (numbers[j] > number) {
                result = numbers[j];
                break;
            }
        }
        answer.push(result);
    }
    return answer;
}