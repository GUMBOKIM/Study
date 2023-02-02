function solution(maps) {
    const rowLen = maps.length;
    const colLen = maps[0].length;
    const answer = [];
    const SEA = 'X';
    const dr = [-1,0,1,0];
    const dc = [0,1,0,-1];
    const visited = Array.from(Array(rowLen),() => new Array(colLen).fill(false));
    const util = (row,col) => {
        let foodSum = parseInt(maps[row][col]);
        for(let dir=0;dir<4;dir++){
            const nr = row + dr[dir];
            const nc = col + dc[dir];
            if(nr >= 0 && nr < rowLen && nc >= 0 && nc < colLen && maps[nr][nc] !== SEA && !visited[nr][nc]){
                visited[nr][nc] = true;
                foodSum += util(nr,nc);
            }
        }
        return foodSum;
    }
    for(let row = 0;row<rowLen;row++){
        for(let col=0;col<colLen;col++){
            const curr = maps[row][col];
            if(curr !== SEA && !visited[row][col]){
                visited[row][col] = true;
                const food = util(row,col);
                answer.push(food);
            }
        }
    }
    if(answer.length === 0){
        return [-1];
    }
    answer.sort((a,b) => a-b);
    return answer;
}