function solution(food) {
    let left = '';
    let middle = '0';
    let right = '';
    for (let i = 1; i < food.length; i++) {
        const dishes = new Array(Math.floor(food[i] / 2)).fill(i).join("");
        left = left + dishes;
        right = dishes + right;
    }
    return ''.concat(left, middle, right);
}