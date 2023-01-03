// function solution(topping) {
//     let answer = 0;
//
//     let A = {};
//     let B = {};
//     topping.forEach(element => addElement(B, element));
//
//     for (let i = 0; i < topping.length; i++) {
//         addElement(A, topping[i]);
//         minusElement(B, topping[i]);
//         if (Object.keys(A).length === Object.keys(B).length) answer++;
//     }
//     return answer;
// }
//
// const addElement = (object, element) => {
//     if (object[element]) {
//         object[element]++
//     } else {
//         object[element] = 1;
//     }
// }
//
// const minusElement = (object, element) => {
//     const value = object[element];
//     if (value === 1) {
//         delete object[element];
//     } else {
//         object[element]--;
//     }
// }

function solution(topping) {
    let answer = 0;

    let A = new Map();
    let B = new Map();
    topping.forEach(key => addElement(B, key));

    for (let i = 0; i < topping.length; i++) {
        addElement(A, topping[i]);
        minusElement(B, topping[i]);
        console.log(A, B);
        if (A.size === B.size) answer++;
    }
    return answer;
}

const addElement = (map, key) => {
    map.set(key, map.has(key) ? map.get(key) + 1 : 1);
}

const minusElement = (map = new Map(), key) => {
    const value = map.get(key);
    if (value === 1) {
        map.delete(key);
    } else {
        map.set(key, map.get(key) - 1);
    }
}