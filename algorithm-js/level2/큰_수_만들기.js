function solution(number, k) {
    const list = [];
    const check = [...Array(number.length)].map(() => 0);

    const bfs = (n, lastIndex, k) => {
        if (n == k) {
            let newNumber = "";
            for (let i = 0; i < number.length; i++) {
                if (check[i] == 0) newNumber += number.charAt(i);
            }
            list.push(Number(newNumber));
        } else {
            for (let i = lastIndex; i < number.length; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    bfs(n + 1, i + 1, k);
                    check[i] = 0;
                }
            }
        }
    }

    bfs(0, -1, k);
    list.sort((a1, a2) => a2 - a1);
    return list[0] + "";
}

function solution(number, k) {
    const arr = [];
    for (let i = 0; i < number.length; i++) {
        while (arr.length > 0 && arr[arr.length - 1] < number[i] && k > 0) {
            k--;
            arr.pop();
        }
        arr.push(number[i]);
    }
    arr.splice(number.length - k, k);
    return arr.join("");
}