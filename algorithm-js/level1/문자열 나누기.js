function solution(s) {
    let answer = 0;

    let nowIndex = 0;
    let firstChar = "";
    let firstCharCnt = 0;
    let otherCharCnt = 0;

    while (nowIndex < s.length) {
        const nowChar = s.at(nowIndex);
        if (firstCharCnt === 0) {
            firstChar = nowChar;
            firstCharCnt++;
            answer++;
        } else {
            if (nowChar === firstChar) {
                firstCharCnt++;
            } else {
                otherCharCnt++;
                if (firstCharCnt === otherCharCnt) {
                    firstChar = "";
                    firstCharCnt = 0;
                    otherCharCnt = 0;
                }
            }
        }
        nowIndex++;
    }

    return answer;
}