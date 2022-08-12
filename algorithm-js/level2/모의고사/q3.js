function solution(distance, scopes, times) {
    let answer = 0;

    let check = new Array(distance + 1).fill(0);

    for (let i = 0; i < scopes.length; i++) {
        let [start, end] = scopes[i];
        let [work, rest] = times[i];
        for (let j = start; j <= end; j++) {
            if (j % (work + rest) <= work) check[j] = 1
        }
    }

    console.log(check)

    while(true) {
        if(check[answer] == 1) break;
        answer ++;
    }

    return answer;
}