function solution(genres, plays) {
    let results = [];
    for (let i = 0; i < genres.length; i++) {
        const genre = genres[i];
        const play = plays[i];

        const findIndex = results.findIndex(result => result.genre === genre);
        if(findIndex === -1) {
            results.push({
                genre: genre,
                totalPlay: play,
                plays: [{play: play, index: i}]
            })
        }else {
            const result = results[findIndex];
            result.totalPlay =+ result.totalPlay + play;
            result.plays.push({play: play, index: i});
        }
    }
    results.sort((a1, a2) => a2.totalPlay - a1.totalPlay);

    let answer = [];
    results.forEach(result => {
        result.plays.sort((a1, a2) => a2.play - a1.play);
        for (let i = 0; i < Math.min(2, result.plays.length); i++) {
            answer.push(result.plays[i].index);
        }
    })

    return answer;
}

console.log(solution(	["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))