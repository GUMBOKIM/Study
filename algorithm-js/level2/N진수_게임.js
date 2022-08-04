function solution(n, t, m, p) {
    let string = '';
    let count = 0;
    while(string.length < m * t){
        string += count.toString(n).toUpperCase();
        count ++;
    }
    console.log(string);

    let answer = '';
    for (let i = 0; i < t; i++) {
        answer += string[p - 1 + i * m];
    }
    return answer;
}

console.log(solution(2, 4, 2, 1))