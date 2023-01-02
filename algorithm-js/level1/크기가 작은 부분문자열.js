function solution(t, p) {
    const t_length = t.length;
    const p_length = p.length;

    let answer = 0;
    for (let i = 0; i <= t_length - p_length; i++) {
        const t_part = t.substring(i, i + p_length);
        if (t_part <= p) answer++;
    }
    return answer;
}

console.log(solution("3141592", "271"))