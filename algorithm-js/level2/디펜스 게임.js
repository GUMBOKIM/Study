// MaxHeap을 구현한다.
// MaxHeap에 관한 코드는 따로 포스팅을 하겠습니다.
class MaxHeap {
    constructor() {
        this.val = [];
    }

    insert(val) {
        this.val.push(val);
        this.bubbleUp();
    }

    bubbleUp() {
        let idx = this.val.length - 1;
        const element = this.val[idx];
        while (idx > 0) {
            let parentIdx = Math.floor((idx - 1) / 2);
            let parent = this.val[parentIdx];
            if (element <= parent) break;
            this.val[parentIdx] = element;
            this.val[idx] = parent;
            idx = parentIdx;
        }
    }

    extractMax() {
        if (!this.val.length) return undefined;

        const max = this.val[0];
        const end = this.val.pop();
        if (this.val.length > 0) {
            this.val[0] = end;
            this.sinkDown();
        }
        return max;
    }

    sinkDown() {
        let idx = 0;
        const element = this.val[0];
        while (true) {
            const leftIdx = idx * 2 + 1;
            const leftVal = this.val[leftIdx];
            const rightIdx = idx * 2 + 2;
            const rightVal = this.val[rightIdx];

            if (element < leftVal && element < rightVal) {
                const maxIdx = leftVal > rightVal ? leftIdx : rightIdx;
                this.val[idx] = this.val[maxIdx];
                this.val[maxIdx] = element;
                idx = maxIdx;
            } else if (element < leftVal) {
                this.val[idx] = leftVal;
                this.val[leftIdx] = element;
                idx = leftIdx;
            } else if (element < rightVal) {
                this.val[idx] = rightVal;
                this.val[rightIdx] = element;
                idx = rightIdx;
            } else {
                break;
            }
        }
    }
}

function solution(n, k, enemy) {
    let answer = 0;

    // 구현한 MapHeap을 선언합니다.
    const maxHeap = new MaxHeap();

    // enemy 배열을 하나씩 확인해줍니다.
    for (let i = 0; i < enemy.length; i++) {
        // maxHeap에 들어온 적의 수를 넣어줍니다.
        // (maxHeap에서 나중에 가져올때 들어간 값들 중 가장 큰 값부터 가져올 수 있다.)
        maxHeap.insert(enemy[i]);

        // 병사 n에서 들어온 적의 수를 빼줍니다.
        n -= enemy[i];

        // 병사가 0명 이하가 됐을 때..
        if (n < 0) {
            // 무적권 스킬이 남아있으면..
            if (k) {
                // maxHeap에서 가장 큰 값을 가져온다.
                // (라운드 중 병력 소모가 가장 많은 값)
                const max = maxHeap.extractMax();

                // n에 가져온 가장 큰 값을 더해주고 무적권을 하나 감소시켜준다.
                n += max;
                k--;

                // 만약 무적권 스킬이 남아있지 않다면 그대로 루프를 종료시킨다.
            } else break;
        }

        // 위의 상황이 다 이뤄졌을 경우 answer을 하나 증가시킨다.
        answer++;
    }

    return answer;
}

console.log(solution(7, 3, [4, 2, 4, 5, 3, 3, 1])); // 5
console.log(solution(2, 4, [3, 3, 3, 3])); // 4