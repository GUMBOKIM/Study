const dRow = [-1, 1, 0, 0];
const dCol = [0, 0, -1, 1];

function solution(maps) {
    const answer = [];
    const width = maps[0].length;
    const height = maps.length;
    const isVisited = Array.from(Array(height), () => Array(width).fill(false));


    const dfs = (row, col) => {
        if (isVisited[row][col]) return 0;
        isVisited[row][col] = true;
        if (maps[row][col] === "X") return 0;
        let value = Number(maps[row][col]);
        for (let i = 0; i < 4; i++) {
            const nextRow = row + dRow[i];
            const nextCol = col + dCol[i];
            if (nextRow >= 0 && nextRow < height && nextCol >= 0 && nextCol < width) {
                value += dfs(nextRow, nextCol);
            }
        }
        return value;
    }


    for (let row = 0; row < height; row++) {
        for (let col = 0; col < width; col++) {
            const value = dfs(row, col);
            if (value !== 0) answer.push(value);
        }
    }

    if (answer.length === 0) return [-1];
    answer.sort();
    return answer;
}