function solution(n, works) {
    const len = works.length;
    works.sort();
    while(n > 0) {
        const max = works[len - 1];
        const startIndex = works.findIndex(work => work === max);
        if(max === 0) break;
        for (let i = startIndex; i < len; i++) {
            if(n > 0) {
                works[i]--;
                n--;
            } else {
                break;
            }
        }
    }

    let result = 0;
    works.forEach(work => result = result + work * work);
    return result;
}
console.log(solution(	1, [2, 1, 2]))