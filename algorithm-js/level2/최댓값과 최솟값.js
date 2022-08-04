function solution(s) {
    let numbers = s.split(" ").map(number => parseInt(number));
    console.log(numbers);
    numbers.sort((a1, a2) => a1 - a2);
    console.log(numbers);
    return numbers[0] + " " + numbers[numbers.length - 1];
}

console.log(solution("-1 -2 -3 -4"	))