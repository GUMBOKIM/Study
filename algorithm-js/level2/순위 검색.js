function solution(info, query) {
    let answer = [];

    let list = [];
    for (const applicant of info) list.push(new Applicant(applicant.split(" ")));

    for (const q of query) {
        let result = 0;
        let split = q.split(/ and | /i);
        console.log(split)
        for (const applicant of list) if(applicant.isPass(split)) result ++;
        answer.push(result);
    }
    return answer;
}

class Applicant {
    constructor([language, group, career, soulFood, score]) {
        this.language = language;
        this.group = group;
        this.career = career;
        this.soulFood = soulFood;
        this.score = score;
    }

    isPass([language, group, career, soulFood, score]) {
        if (language !== "-" && this.language != language) return false;
        if (group !== "-" && this.group != group) return false;
        if (career !== "-" && this.career != career) return false;
        if (soulFood !== "-" &&  this.soulFood != soulFood) return false;
        if (score !== "-" && parseInt(this.score) < parseInt(score)) return false;
        console.log(this)
        return true;
    }
}

console.log(solution(
    ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 150"],
    ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))

function solution(info, query) {
    let answer = [];
    let userMap = new Map();

    for (let i = 0; i < info.length; i++) {
        let user = info[i].split(" ");
        let userkey = `${user[0][0]}${user[1][0]}${user[2][0].toUpperCase()}${user[3][0].toUpperCase()}`;
        if (userMap.has(userkey)) {
            userMap.set(userkey, [...userMap.get(userkey), Number(user[4])]);
        } else {
            userMap.set(userkey, [Number(user[4])]);
        }
    }
    for (let [key, value] of userMap) {
        userMap.set(
            key,
            value.sort((a, b) => a - b)
        );
    }
    for (let i = 0; i < query.length; i++) {
        let count = 0;
        let condition = query[i].split(" ");
        let conditionKey = `${condition[0][0]}${condition[2][0]}${condition[4][0].toUpperCase()}${condition[6][0].toUpperCase()}`;
        for (let [key, value] of userMap) {
            conditionKey = conditionKey.replace(/\-/g, "");
            let contain = true;
            for (let i = 0; i < conditionKey.length; i++) {
                if (!key.includes(conditionKey[i])) {
                    contain = false;
                    break;
                }
            }
            if (contain) {
                const index = binarySearch(value, Number(condition[7]));
                count += value.length - index;
            }
        }
        answer.push(count);
    }
    return answer;
}

function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] < target) left = mid + 1;
        else right = mid;
    }
    return left;
}
