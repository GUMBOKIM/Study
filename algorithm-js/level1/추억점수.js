function solution(name, yearning, photo) {
    const scoreMap = new Map();
    for (let i = 0; i < name.length; i++) scoreMap.set(name[i], yearning[i]);
    
    const answer = [];
    photo.forEach(names => {
        let score = 0;
        names.forEach(name => {
            if (scoreMap.has(name)) score += scoreMap.get(name);
        })
        answer.push(score);
    })
    return answer;
}
