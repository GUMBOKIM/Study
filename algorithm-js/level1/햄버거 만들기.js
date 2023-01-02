function solution(ingredient) {
    let answer = 0;
    let stack = [];
    for (let i = 0; i < ingredient.length; i++) {
        const nowIngredient = ingredient[i];
        if (stack.length < 3) {
            stack.push(nowIngredient);
        } else {
            const length = stack.length;
            if (nowIngredient === 1 && stack[length - 1] === 3 && stack[length - 2] === 2 && stack[length - 3] === 1) {
                stack.pop();
                stack.pop();
                stack.pop();
                answer++;
            } else {
                stack.push(nowIngredient);
            }
        }
    }
    return answer;
}