function solution(sticker) {
    const length = sticker.length;
    const check = new Array(length).fill(true);

    let answer = 0;
    const recursive = (index, sum) => {
        if (index < length) {
            for (let i = index + 1; i <= length; i++) {

            }
        } else {
            answer = Math.max(answer, sum);
        }
    }

    recursive(-1, 0);

    return answer;
}