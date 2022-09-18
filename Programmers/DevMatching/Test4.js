let stackCount;

function solution(n, queries) {
    stackCount = n;
    let sharedStack = [-1];
    let nonSharedStacks = Array.from(Array(n + 1), () => []);

    let answer = [];
    queries.forEach(query => {
        let [stackNumber, value] = query;
        if (value !== -1) {
            customPush(stackNumber, value, sharedStack, nonSharedStacks);
        } else {
            answer.push(customPop(stackNumber, sharedStack, nonSharedStacks, answer));
        }
    })

    return answer;
}


const customPush = (stackNumber, value, sharedStack, nonSharedStacks) => {
    if (sharedStack[0] !== -1) {
        nonSharedStacks[stackNumber].push(value);
    } else {
        sharedStack[0] = value;
    }
}

const customPop = (stackNumber, sharedStack, nonSharedStacks) => {
    let pop = -1;
    if (nonSharedStacks[stackNumber].length !== 0) {
        pop = nonSharedStacks[stackNumber].pop();
    } else {
        if (sharedStack[0] !== -1) {
            pop = sharedStack[0];
            sharedStack[0] = -1;
            let nextStackNumber = findAdjacentStack(stackNumber);
            while (nextStackNumber !== stackNumber) {
                if (nonSharedStacks[nextStackNumber].length !== 0) {
                    sharedStack[0] = nonSharedStacks[nextStackNumber][0];
                    nonSharedStacks[nextStackNumber] = nonSharedStacks[nextStackNumber].slice(1);
                    break;
                } else {
                    nextStackNumber = findAdjacentStack(nextStackNumber);
                }
            }
        }
    }

    return pop;
}

const findAdjacentStack = (stack) => {
    if (stackCount === stack) return 1;
    return stack + 1;
}