function solution(n) {
    let answer = 0;
    let share = n;
    let remainder = 0;

    while(share > 0) {
        remainder = share % 2
        share = Math.floor(share / 2);
        answer += remainder;
    }
    return answer;
}
solution(5000);



//1 - 1 => 1 => (0, 1)
//2 - 1 => 2 => (1, 0)
//3 - 2 => 3 => (1, 1^) => (1^, 0^)
//4 - 2 => 4 => (2, 0^) => (1^, 0^)
//5 - 2 => 5 => (2, 1^) => (1^, 0^)
//6 - 2 => 6 => (3, 0^_ => (1^, 1^))

