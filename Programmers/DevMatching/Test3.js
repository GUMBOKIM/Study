let yLen;
let xLen;

function solution(board, y, x) {
    if(board[y][x] === MARK.MINE) {
        board[y] = changeCharacter(board[y], x, MARK.MINE_SELECT);
        return board;
    }

    yLen = board.length;
    xLen = board[0].length;
    let answer = Array.from(Array(yLen), () => Array(xLen).fill(MARK.EMPTY).join(""));
    let visited = Array.from(Array(yLen), () => Array(xLen).fill(true));
    execute(board, answer, visited, y, x)
    return answer;
}

const dx = [-1,0,1,-1,1,-1,0,1]
const dy = [1,1,1,0,0,-1,-1,-1];

const execute = (board, answer, visited, y, x) => {
    if(visited[y][x]) {
        visited[y][x] = false;
        let mineCount = countAdjacentMine(board, x, y);
        if(mineCount == 0) {
            answer[y] = changeCharacter(answer[y], x, MARK.BLANK);
            for (let i = 0; i <= 8; i++) {
                if(isMoveAble(x + dx[i],  y + dy[i])) execute(board, answer, visited, y + dy[i], x + dx[i]);
            }
        } else {
            answer[y] = changeCharacter(answer[y], x, mineCount + "");
        }
    }
}

const countAdjacentMine = (board, x, y) => {
    let mineCount = 0;
    for (let i = 0; i <= 8; i++) {
        if(isMoveAble(x + dx[i],  y + dy[i])) {
            if (board[y + dy[i]][x + dx[i]] === MARK.MINE) mineCount++;
        }
    }
    return mineCount;
}

const isMoveAble = (x, y) => {
    return x < xLen && x >= 0 && y < yLen && y >= 0;
}

const changeCharacter = (string, index, value) => {
    const charArr = string.split("");
    charArr[index] = value;
    return charArr.join("");
}

const MARK = {
    MINE: "M",
    BLANK: "B",
    EMPTY: "E",
    MINE_SELECT: "X"
}