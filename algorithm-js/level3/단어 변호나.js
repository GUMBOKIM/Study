function solution(begin, target, words) {
    // 처음에 있는지 아닌지
    if(words.findIndex(w => target === w) === -1) return 0;
    else {
        let answer = 0;

        const map = createMap([begin, ...words]);

        let set = new Set();
        set.add(begin);

        while(!set.has(target)){
            answer ++;
            const newSet = new Set();
            for (const word of set) {
                const nextWordArr = map[word];
                for (const nextWord of nextWordArr) {
                    newSet.add(nextWord);
                }
            }
            set = newSet;
        }
        console.log(answer)
        return answer;
    }

}

const createMap = (words) => {
    let map = {};
    for (let i = 0; i < words.length; i++) {
        for (let j = 0; j < words.length; j++) {
            if(i != j && isChangeable(words[i], words[j])) {
                addObjectProperty(map, words[i], words[j]);
            }
        }
    }
    return map;
}

const isChangeable = (w1, w2) => {
    let differCount = 0;
    for (let i = 0; i < w1.length; i++) {
        if(w1[i] !== w2[i]) differCount ++;
    }
    return differCount === 1;
}

const addObjectProperty = (object, key, value) => {
    if(!object[key]) {
        object[key] = [];
    }
    object[key].push(value);
}

solution(		"hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]);