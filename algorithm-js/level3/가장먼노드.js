function solution(n, edge) {
    let answer = 0;
    let queue = [];
    let dist = new Array(n+1).fill(-1);
    dist[1] = 0;

    let graph = new Array(n+1).fill(0).map(e => [])

    for (let i of edge) {
        graph[i[0]].push(i[1]);
        graph[i[1]].push(i[0]);
    }
    queue.push(1)

    while (queue.length != 0) {
        let cur = queue.shift();
        for (let i = 1; i <= n; i++) {
            if (graph[cur].indexOf(i) != -1 && dist[i] == -1) {
                dist[i] = dist[cur] + 1;
                queue.push(i);
            }
        }
    }

    let max = Math.max(...dist)
    answer = dist.reduce((prev,next) => prev + ((next==max)?1:0),0)
    return answer;
}

console.log(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))