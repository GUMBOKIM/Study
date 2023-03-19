function solution(n) {
    const answer = [];
    const execute = (n, src, dst, mid) => {
        if (n === 1) answer.push([src, dst]);
        else {
            execute(n - 1, src, mid, dst);
            answer.push([src, dst]);
            execute(n - 1, mid, dst, src);
        }
    }
    execute(n, 1, 3, 2);

    return answer;
}