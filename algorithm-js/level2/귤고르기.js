function solution(k, tangerine) {
    const map = {};
    for (let i = 0; i < tangerine.length; i++) {
        const size = tangerine[i];
        if (map[size]) {
            map[size]++;
        } else {
            map[size] = 1;
        }
    }

    const arr = Object.values.map(key => map[key]).sort((a, b) => b - a);

    let sum = 0;
    let answer = 0;

    while (sum < k) {
        sum += arr[answer];
        answer++;
    }

    return answer;
}