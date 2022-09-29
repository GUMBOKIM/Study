function solution(queries) {
    let answer = 0;

    const arrayNumbers = new Array(1000).fill(0);
    const arraySizes = new Array(1000).fill(0);

    const calculateArraySize = (elementNumber) => {
        let arraySize = 1;
        while(arraySize < elementNumber) {
            arraySize = arraySize * 2;
        }
        return arraySize;
    }

    const execute = (query) => {
        const [arrayIndex, elementNumber] = query;
        const arrayNumber = arrayNumbers[arrayIndex];
        const arraySize = arraySizes[arrayIndex];
        if (arrayNumber + elementNumber >= arraySize) {
            const newArraySize = calculateArraySize(arrayNumber + elementNumber);
            answer = answer + arrayNumber;
            arraySizes[arrayIndex] = newArraySize;
            arrayNumbers[arrayIndex] = arrayNumber + elementNumber;
        }
        arrayNumbers[arrayIndex] = arrayNumber + elementNumber;
    }

    queries.forEach(query => execute(query));


    return answer;
}


console.log(solution(
    [[2, 10], [7, 1], [2, 5], [2, 9], [7, 32]]))