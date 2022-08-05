function solution(n) {
    let answer = 0;
    let count = 0;
    while(n - count >= count) {
        answer += combination(n - count, count);
        count ++;
    }
    return answer;
}

function combination(n, r) {
    // if(r == 0 || r == n) return 1;
    r = n - r > r ? r : n - r;
    let result = 1;
    for (let i = n; i > n - r ; i--) result *= i;
    for (let i = r; i >= 1; i--) result /= i;
    return result;
}

console.log(solution(6))
