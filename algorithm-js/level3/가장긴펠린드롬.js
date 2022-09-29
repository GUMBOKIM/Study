function solution(s) {
    for (let i = s.length; i >= 1; i--) {
        for (let j = 0; j <= s.length - i; j++) {
            if (check(s.slice(j, i + j))) return i;
        }
    }
    return 1;
}

const check = (string) => {
    for (let i = 0; i < string.length / 2; i++) {
        if (string[i] !== string[string.length - 1 - i]) return false;
    }
    return true;
}

console.log(solution("abcdcba"));