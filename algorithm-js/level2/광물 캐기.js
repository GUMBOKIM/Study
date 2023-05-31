function solution(picks, minerals) {
    var answer = 0;
    const sortArr = [];  // 5개씩 자른 [다, 철, 돌]의 개수가 담기는 2차원 배열
    const tired = [
        [1, 1, 1],
        [5, 1, 1],
        [25, 5, 1]
    ];

    const len = Math.ceil(minerals.length / 5);     // 광물을 5개씩 자른 횟수
    const maxLen = picks[0] + picks[1] + picks[2];  // 곡괭이의 개수

    for (let i = 0; i < len; i++) {
        // 1) 곡괭이가 없으면 광물을 캘 수 없으므로 곡괭이 개수 보다 크면 반복문을 빠져나온다.
        if (i >= maxLen) break;

        const arr = [0, 0, 0];  // 다이아몬드, 철, 돌 개수

        // 2) 광물을 5개씩 자르고, 자른 광물을 다이아몬드, 철, 돌의 개수를 카운트한다.
        minerals.splice(0, 5).forEach(item => {
            switch (item) {
                case "diamond" :
                    arr[0]++;
                    break;
                case "iron" :
                    arr[1]++;
                    break;
                default :
                    arr[2]++;
                    break;
            }
        });

        // 3) 배열에 추가한다.
        sortArr.push(arr);
    }

    // 4) 다이아몬드 > 철 > 돌 우선순위로 내림차순 정렬한다.
    sortArr.sort((a, b) => {
        if (a[0] === b[0]) {
            if (a[1] === b[1]) {
                return b[2] - a[2];
            } else {
                return b[1] - a[1];
            }
        } else {
            return b[0] - a[0];
        }
    });

    // 5) 채광한 광물들의 피로도를 계산한다.
    sortArr.forEach(item => {
        const [d, i, s] = item;          // 다이아몬드, 철, 돌
        let idx = 0;

        // 6) 피로도를 계산하기 위해 곡괭이가 있을 경우 다 > 철 > 돌 순의로 idx를 설정한다.
        if (picks[0] !== 0) idx = 0;
        else if (picks[1] !== 0) idx = 1;
        else if (picks[2] !== 0) idx = 2;

        if (picks[idx] !== 0) {
            // 7) idx(0:다, 1:철, 2:돌) 곡괭이를 사용할 경우 다, 철, 돌의 피로도를 계산한다.
            answer += (tired[idx][0] * d);
            answer += (tired[idx][1] * i);
            answer += (tired[idx][2] * s);

            // 8) 사용한 곡괭이를 감소시킨다.
            picks[idx]--;
        }
    });

    return answer;
}