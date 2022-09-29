function solution(queue1, queue2) {
    const targets = createTargetQueues(queue1, queue2);
    if (targets.length === 0) return -1
    else {
        let operationCount = Number.MAX_VALUE;

        targets.forEach(target => {
            const operation = calculateOperation(target, queue1, queue2);
            if (operation < operationCount) operationCount = operation;
        })

        return operationCount;
    }

}

const createTargetQueues = (queue1, queue2) => {
    const targets = [];
    const targetSum = (sumArr(queue1) + sumArr(queue2)) / 2;

    if (!isInteger(targetSum)) {
        return targets;
    } else {
        const elements = [...queue1, ...queue2];
        const elementsLength = elements.length;
        elements.sort();

        const selectTarget = (lastIndex, beforeMap, arrSum) => {
            if (lastIndex >= elementsLength || arrSum > targetSum) {
                return;
            } else if (arrSum === targetSum) {
                targets.push(beforeMap);
            } else {
                for (let i = lastIndex + 1; i < elementsLength; i++) {
                    const newMap = new Map(beforeMap);
                    newMap.set(elements[i], newMap.has(elements[i]) ? newMap.get(elements[i]) + 1 : 1)
                    selectTarget(i, newMap, arrSum + elements[i]);
                }
            }
        }
        selectTarget(-1, new Map(), 0);
        return targets;
    }
};

const calculateOperation = (target, queue1, queue2) => {
    let count = 0;
    let targetLength = sumValuesInMap(target);


    while (!isQueueEqualTarget(target, queue1)) {
        count++;
        let element;
        if (queue1.length <= targetLength) {
            element = queue2.shift();
        } else {
            element = queue1.shift();
        }
        if (isQueueNeed(target, queue1, element)) {
            queue1.push(element);
        } else {
            queue2.push(element);
        }

        console.log(count, queue1, queue2)
    }
    return count;
}

const isQueueNeed = (target, queue, selectElement) => {
    const copyTarget = new Map(target)
    for (let element in queue) {
        if (copyTarget.has(element)) {
            const value = copyTarget.get(element);
            if (value !== 0) copyTarget.set(element, value - 1);
        }
    }
    if (copyTarget.has(selectElement) && copyTarget.get(selectElement) >= 1) return true;
    else return false;
}

const isQueueEqualTarget = (target, queue) => {
    const copyTarget = new Map(target)
    for (let element in queue) {
        if (copyTarget.has(element)) {
            const value = copyTarget.get(element);
            if (value === 0) return false;
            else {
                copyTarget.set(element, value - 1);
            }
        } else return false;
    }
    return true;
}

const isInteger = (number) => number % 1 === 0;
const sumArr = (arr) => arr.reduce((sum, currValue) => sum + currValue, 0);
const sumValuesInMap = (map) => {
    let result = 0;
    for (let [_, value] of map) {
        result = result + value;
    }
    return result;
}

console.log(solution([3, 2, 7, 2], [4, 6, 5, 1]))