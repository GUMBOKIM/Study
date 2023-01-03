function solution(k, ranges) {
    const areas = calculateArea(k);
    return ranges.map(range => summaryArea(areas, range));
}


const calculateArea = (startNumber) => {
    const areas = [];
    let nowNumber = startNumber;
    while (nowNumber > 1) {
        const beforeNumber = nowNumber;
        if (nowNumber % 2 === 0) {
            nowNumber = nowNumber / 2;
        } else {
            nowNumber = nowNumber * 3 + 1;
        }
        areas.push((beforeNumber + nowNumber) / 2);
    }
    return areas;
}

const summaryArea = (areas, [start, end]) => {
    const length = areas.length;
    if (start > length + end) return -1;

    let sum = 0;
    for (let i = start; i < length + end; i++) {
        sum += areas[i];
    }
    return sum;
}