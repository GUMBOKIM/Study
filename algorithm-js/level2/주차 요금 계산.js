function calculateTime(records, timeMap) {
    for (const record of records) {
        let [nowTime, car, nowKind] = record.split(" ");
        if (!timeMap.has(car)) {
            timeMap.set(car, [nowTime, nowKind, 0]);
        } else {
            let [beforeTime, beforeKind, calculateTime] = timeMap.get(car);
            if (beforeKind === "IN") {
                let [beforeHour, beforeMinute] = beforeTime.split(":");
                let [nowHour, nowMinute] = nowTime.split(":");
                calculateTime += (parseInt(nowHour) - parseInt(beforeHour)) * 60 + (parseInt(nowMinute) - parseInt(beforeMinute));
            }
            timeMap.set(car, [nowTime, nowKind, calculateTime]);
        }
    }

    for (let [car, [time, kind, calculateTime]] of timeMap) {
        if (kind === "IN") {
            let [hour, minute] = time.split(":");
            calculateTime += (23 - parseInt(hour)) * 60 + (59 - parseInt(minute));
            timeMap.set(car, ["23:59", "OUT", calculateTime])
        }
    }
}

function calculateFee(timeMap, answer, fees) {
    for (let [car, _] of timeMap) answer.push(car);
    answer.sort();

    const [basicTime, basicFee, unitTime, unitFee] = fees;

    for (let i = 0; i < answer.length; i++) {
        let car = answer[i];
        const [_, __, time] = timeMap.get(car);
        let result = time <= basicTime ? basicFee : basicFee + Math.ceil((time - basicTime) / unitTime) * unitFee;
        answer[i] = result;
    }
}

function solution(fees, records) {
    let answer = [];
    let timeMap = new Map();
    calculateTime(records, timeMap);
    calculateFee(timeMap, answer, fees);
    return answer;
}

console.log(
    solution(
        [180, 5000, 10, 600],
        ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
    )
)