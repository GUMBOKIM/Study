function solution(data, col, row_begin, row_end) {
    // 테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
    data.sort((a, b) => {
        const result = a[col - 1] - b[col - 1];
        return result === 0 ? b[0] - a[0] : result;
    });
    // 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
    const arr = [];
    for (let i = row_begin - 1; i < row_end; i++) {
        arr.push(data[i].reduce((accumulator, currentValue) => accumulator + (currentValue % (i + 1)), 0));
    }
    // row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
    return arr.reduce((accumulator, currentValue) => accumulator ^ currentValue);
}