function solution(number, limit, power) {
    let answer = 0;
    for (let i = 1; i <= number; i++) {
        const divisorCount = countDivisor(i);
        if (divisorCount <= limit) {
            answer += divisorCount;
        } else {
            answer += power;
        }
    }
    return answer;
}


const countDivisor = number => {
    let count = 0;
    let sqrt = Math.sqrt(number);
    for (let i = 1; i <= sqrt; i++) {
        if (number % i === 0) {
            count++;
            if (i !== sqrt) count++;
        }
    }
    return count;
}