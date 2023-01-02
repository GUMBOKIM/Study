function solution(a, b, n) {
    let answer = 0;
    let colaCount = n;
    let bottleCount = 0;
    while (colaCount != 0) {
        bottleCount += colaCount;
        const share = Math.floor(bottleCount / a);
        const remainder = bottleCount % a;
        colaCount = share * b;
        answer += colaCount;
        bottleCount = remainder;
    }
    return answer;
}