const MARKINKG = {
    "시작지점": "S",
    "출구": "E",
    "레버": "L",
    "통로": "O",
    "벽": "X",
}

function solution(maps) {
    let answer = 0;
    const [startLocation, endLocation, leverLocation] = findLocation(maps);
    return answer;
}

const findLocation = (maps = [[]]) => {
    let startLocation = {};
    let endLocation = {};
    let leverLocation = {};
    for (let row = 0; row < maps.length; row++) {
        const arr = maps[row];
        for (let col = 0; col < arr.length; col++) {
            if (maps[row][col] === MARKINKG.시작지점) startLocation = {row, col};
            if (maps[row][col] === MARKINKG.출구) endLocation = {row, col};
            if (maps[row][col] === MARKINKG.레버) leverLocation = {row, col};
        }
    }
    return [startLocation, endLocation, leverLocation];
}

const calculateDistance = (maps, locations) => {

}