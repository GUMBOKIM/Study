function solution(cards) {
    const cardLength = cards.length;
    const isBoxOpen = new Array(cardLength).fill(false);
    const result = [];
    for (let boxIndex = 0; boxIndex < cardLength; boxIndex++) {
        if (!isBoxOpen[boxIndex]) {
            let count = 1;
            isBoxOpen[boxIndex] = true;
            let selectCard = cards[boxIndex];
            while (true) {
                if (isBoxOpen[selectCard - 1]) {
                    break;
                } else {
                    count++;
                    isBoxOpen[selectCard - 1] = true;
                    selectCard = cards[selectCard - 1];
                }
            }
            result.push(count);
        }
    }
    result.sort((a, b) => b - a);
    return result[0] * (result[1] ? result[1] : 0);
}