function solution(n, computers) {
    let answer = 0
    const checked = new Array(n).fill(false)
    const newNetwork = (startComputer) => {
        const toBeVisited = [startComputer]
        while (toBeVisited.length > 0) {
            const currentComputer = toBeVisited.pop()
            checked[currentComputer] = true
            for (let nextComputer = 0; nextComputer < n; nextComputer++) {
                if (!checked[nextComputer] && computers[currentComputer][nextComputer]) {
                    toBeVisited.push(nextComputer)
                }
            }
        }
    }

    for (let startComputer = 0; startComputer < n; startComputer++) {
        if (!checked[startComputer]) {
            newNetwork(startComputer)
            answer++
        }
    }
    return answer
}