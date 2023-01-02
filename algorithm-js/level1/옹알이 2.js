const pronunciations = ["aya", "ye", "woo", "ma"];

function solution(babbling) {
    let answer = 0;
    babbling.forEach(word => {
        if (isSpeakable(word)) answer++;
    })
    return answer;
}

const isSpeakable = (word) => {
    pronunciations.forEach((pronunciation, index) => word = word.replaceAll(pronunciation, (index + 1)));
    if (Number.isInteger(Number(word))) {
        let before = 0;
        for (let i = 0; i < word.length; i++) {
            const now = word[i];
            if (before === now) return false;
            before = now;
        }
        return true;

    }
    return false;
}