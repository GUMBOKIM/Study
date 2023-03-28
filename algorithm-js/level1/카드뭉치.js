const solution = (cards1, cards2, goal) => {
    let card1 = cards1
    let card2 = cards2
    for (let i of goal) {
        if (card1.indexOf(i) === 0) card1.shift();
        else if (card2.indexOf(i) === 0) card2.shift();
        else return "No"
    }
    return "Yes"
}