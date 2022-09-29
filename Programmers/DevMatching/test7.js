function solution(n, m, fires, ices) {
    const temperatureMap = Array.from(Array(n), () => Array(n).fill(0));
    const hotMap = Array.from(Array(n), () => Array(n).fill(0));
    const coldMap = Array.from(Array(n), () => Array(n).fill(0));

    let time = 0;

    const increaseHotMap = (time) => {
        fires.forEach(fire => {
            const x = fire[0] - 1;
            const y = fire[1] - 1;
            //오른
            if (y + time < n) {
                for (let i = x - time + 1; i <= x + time; i++) {
                    if (i < n && i >= 0) hotMap[i][y + time]++;
                }
            }
            if (y - time >= 0) {
                for (let i = x - time; i < x + time; i++) {
                    if (i < n && i >= 0) hotMap[i][y - time]++;
                }
            }

            if (x + time < n) {
                for (let i = y - time; i < y + time; i++) {
                    if (i < n && i >= 0) hotMap[x + time][i]++;
                }
            }
            if (x - time >= 0) {
                for (let i = y - time; i < y + time; i++) {
                    if (i < n && i >= 0) hotMap[x - time][i]++;
                }
            }

            if (time === 1) hotMap[x][y]++;
        })
    }

    const increaseColdMap = (time) => {
        ices.forEach(ice => {
            const x = ice[0] - 1;
            const y = ice[1] - 1;

            for (let i = 0; i < time; i++) {
                let nextX;
                let nextY;

                nextX = x - i;
                nextY = y - time + i;
                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0) {
                    coldMap[nextX][nextY]++;
                }

                nextX = x + i;
                nextY = y + time - i;
                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0) {
                    coldMap[nextX][nextY]++;
                }

                nextX = x - time + i;
                nextY = y - i;
                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0) {
                    coldMap[nextX][nextY]++;
                }

                nextX = x + time - i;
                nextY = y + i;
                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0) {
                    coldMap[nextX][nextY]++;
                }
            }
            if (time === 1) coldMap[x][y]++;
        })
    }

    const reflectTemperatureMap = () => {
        for (let x = 0; x < n; x++) {
            for (let y = 0; y < n; y++) {
                if (hotMap[x][y] === 1) temperatureMap[x][y] = temperatureMap[x][y]+ hotMap[x][y];
                if (coldMap[x][y] === 1) temperatureMap[x][y] = temperatureMap[x][y] + coldMap[x][y];
            }
        }
    }


    while (m != time) {
        time++;
        increaseHotMap(time);
        increaseColdMap(time);
        reflectTemperatureMap();
        console.log(time);
        console.log("hotMap");
        for (const temper of hotMap) {
            console.log(temper);
        }
        console.log("coldMap");
        for (const temper of coldMap) {
            console.log(temper);
        }
        console.log("result");
        for (const temper of temperatureMap) {
            console.log(temper);
        }

    }

    return temperatureMap;
}

solution(5, 3, [[5, 5], [1, 3], [5, 2]], [[1, 5], [3, 2]]);
