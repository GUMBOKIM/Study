function solution(keymaps, targets) {
    const answer = [];
    targets.forEach(target => answer.push(calculateClick(keymaps, target)));
    return answer;
}

const calculateClick = (keymaps, target) => {
    let answer = 0;
    const chars = target.split("");
    for (let i = 0; i < chars.length; i++) {
        const char = chars[i];
        const indexArr = keymaps.filter(keymap => keymap.includes(char)).map(keymap => keymap.indexOf(char));
        if (indexArr.length === 0) return -1;
        answer = answer + Math.min(...indexArr) + 1;
    }
    return answer;
}