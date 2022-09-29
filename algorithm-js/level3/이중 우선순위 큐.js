function solution(operations) {
    let queue = [];

    operations.forEach(operation => {
        queue = execute(queue, operation)
    });

    if (queue.length === 0) {
        return [0, 0];
    }
    return [queue[queue.length - 1].value, queue[0].value];
}

const execute = (queue, operation) => {
    const [kind, value] = operation.split(" ")
    if (kind === "I") {
        return insertValue(queue, Number(value));
    } else if (kind === "D" && queue.length !== 0) {
        if (value === "1") {
            return deleteMax(queue);
        } else if (value === "-1") {
            return deleteMin(queue);
        }
    }
}

const insertValue = (queue, value) => {
    let lower = queue.filter(element => element.value < value);
    let bigger = queue.filter(element => element.value > value);
    let same = queue.filter(element => element.value === value);
    if (same.length === 0) same = [{value: value, count: 1}];
    else same[0].count++;
    return [...lower, ...same, ...bigger];
}

const deleteMax = (queue) => {
    if (queue[queue.length - 1].count === 1) {
        queue.pop();
    } else {
        queue[queue.length - 1].value--;
    }
    return queue;
}

const deleteMin = (queue) => {
    if (queue[0].count === 1) {
        queue = queue.slice(1);
    } else {
        queue[0].value--;
    }
    return queue;
}

console.log(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))