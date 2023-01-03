function solution(elements) {
    const size = elements.length;
    const result = new Set();
    // 길이가 size 일때
    result.add(elements.reduce((sum, cv) => sum + cv));
    // 길이가 size 아닐떄
    for (let len = 1; len < size; len++) {
        let sum = 0;
        for (let i = 0; i < len; i++) sum += elements[i];
        result.add(sum);
        for (let start = 0; start < size - 1; start++) {
            const before = start;
            const last = start + len;
            sum = sum - elements[before] + elements[last < size ? last : last - size];
            result.add(sum);
        }
    }

    return result.size;
}