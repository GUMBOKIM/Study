function solution(s, skip, index) {
    const alphabets = new Array(24);
    // 소문자 a는 97, 소문자 z는 122
    for (let i = 0; i <= 24; i++) alphabets[i] = String.fromCharCode(i + 97);
    const filteredAlphabets = alphabets.filter(alphabet => !skip.includes(alphabet));
    const filteredAlphabetsLength = filteredAlphabets.length;
    console.log(filteredAlphabets);
    const result = s.split("").map(char => {
        let alphaIndex = filteredAlphabets.indexOf(char) + index;
        while(alphaIndex >= filteredAlphabetsLength){
            alphaIndex = alphaIndex - filteredAlphabetsLength;
        }
        return filteredAlphabets[alphaIndex];
    }).join("");
    console.log(result);
    return result;
}

console.log(solution("aukks",	"wbqd",	5));

