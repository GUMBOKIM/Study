const convertDate = (date) => {
    const dateArr = date.split('.');
    return {
        year: Number(dateArr[0]),
        month: Number(dateArr[1]),
        day: Number(dateArr[2]),
    }
}

const isValid = (today, start, period) => {
    return (today.year - start.year) * 12 * 28 + (today.month - start.month) * 28 + (today.day - start.day) >= period * 28
}

function solution(today, terms, privacies) {
    const answer = [];
    const todayDate = convertDate(today);
    const termMap = new Map();
    terms.forEach(term => {
        const [kind, period] = term.split(" ");
        termMap.set(kind, Number(period));
    });

    privacies.forEach((privacy, index) => {
        const [start, kind] = privacy.split(" ");
        if (isValid(todayDate, convertDate(start), termMap.get(kind))) {
            answer.push(index + 1);
        }

    })


    return answer;
}