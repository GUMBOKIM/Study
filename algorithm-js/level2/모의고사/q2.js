// function solution(ingredients) {
//     let answer = 0;
//
//     let recipe = [1, 2, 3, 1];
//
//     let index = 0;
//     while(index < ingredients.length) {
//         let count = 0;
//         for (let j = 0; j < 4; j++) {
//             if (ingredients[index + j] != recipe[j]) break;
//             count ++;
//         }
//         if(count == 4) {
//             answer ++;
//             ingredients = [...ingredients.slice(0, index), ...ingredients.slice(index + 4)]
//             index --;
//         } else {
//             index ++;
//         }
//     }
//     return answer;
// }

function solution(ingredients) {
    let answer = 0;
    let recipe = [1, 3, 2, 1];

    let stack = [];

    for (const ingredient of ingredients) stack.push(ingredient);
    console.log(stack);

    let seq = 0;
    while (stack.length >= 4) {
        let ingredient = stack.pop();
        console.log(ingredient);
        if (ingredient == recipe[seq]) {
            seq ++;
            if(seq == 4) {
                console.log(stack);
                answer ++
                seq = 0;
            }
        } else seq = 0;
    }

    return answer;
}


console.log(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]));