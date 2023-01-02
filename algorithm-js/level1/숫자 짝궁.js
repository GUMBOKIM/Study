function solution(X, Y) {
    const mapX = createNumberMap(X);
    const mapY = createNumberMap(Y);

    let answer = '';
    Object.keys(mapX).forEach(key => {
        const cntX = mapX[key];
        const cntY = mapY[key];
        if (cntY) {
            const minCnt = Math.min(cntX, cntY);
            answer = new Array(minCnt).fill(key).join("") + answer;
        }
    })

    if (answer === '') answer = '-1';
    if (answer.at(0) === '0') return "0";
    return answer;
}

const createNumberMap = (number) => {
    const map = {};
    number.split("").forEach(num => Object.keys(map).includes(num) ? map[num]++ : map[num] = 1);
    return map;
}