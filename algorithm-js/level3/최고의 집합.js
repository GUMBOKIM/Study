function solution(n, s) {
    if(s < n) return [-1];
    return createCombination(n ,s);
}

const createCombination = (n, s) => {
    const quotient = Math.floor(s / n);
    const remainder = s % n;

    const result = new Array(n).fill(quotient);
    for (let i = 0; i < remainder; i++) {
        result[n - 1 - i] ++;
    }
    return result;
}

console.log(solution(2, 8))