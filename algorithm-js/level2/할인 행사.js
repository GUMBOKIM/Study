function solution(want, number, discount) {
    const discountMap = new Map();
    let answer = 0;

    const isValid = () => {
        for (let i = 0; i < want.length; i++) {
            const product = want[i];
            const amount = number[i];
            if (discountMap.has(product)) {
                if (discountMap.get(product) < amount) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    // 처음
    for (let i = 0; i < 10; i++) {
        const product = discount[i];
        addElement(discountMap, product);
    }
    if (isValid()) answer++;

    // 처음 이후
    for (let i = 0; i < discount.length - 9; i++) {
        const addProduct = discount[i + 10];
        addElement(discountMap, addProduct);
        const removeProduct = discount[i]
        minusElement(discountMap, removeProduct);
        if (isValid()) answer++;
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