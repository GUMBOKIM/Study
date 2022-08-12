function solution(n, lighthouse) {
    let map = {};
    for (const root of lighthouse) {
        let [start, end] = root;
        if(!map[start]) {
            map[start] = [];
        }
        map[start].push(end);


        if(!map[end]) {
            map[end] = [];
        }
        map[end].push(start);
    }

    let check = new Array(n + 1).fill(0);

    console.log(map);

    let answer = 0;

    return answer;
}

console.log(solution(8, [[1, 2], [1, 3], [1, 4], [1, 5], [5, 6], [5, 7], [5, 8]]))