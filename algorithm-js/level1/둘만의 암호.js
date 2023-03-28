function solution(s, skip, index) {
    var answer = '';
    const skipCode = skip.split('').map(c => c.charCodeAt(0))
    const converted = s.split('').map(c => {
        let convert = c.charCodeAt(0)
        for (let i = 0; i < index; i++) {
            convert++;
            while (skipCode.includes(convert)) convert++;
            if (convert == 'z'.charCodeAt(0) + 1) convert = 'a'.charCodeAt(0)
            while (skipCode.includes(convert)) convert++;
        }
        return convert
    })
    answer = String.fromCharCode(...converted)
    return answer;
}