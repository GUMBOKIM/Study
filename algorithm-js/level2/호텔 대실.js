const convertMinutes = (time) => {
    const [hour, minute] = time.split(":");
    return Number(hour) * 60 + Number(minute);
}

function solution(book_time) {
    const times = book_time.map((time) => ([convertMinutes(time[0]), convertMinutes(time[1])]));
    const roomEndTimes = [];
    times.sort((a, b) => a[0] - b[0]);
    console.log(times);
    times.forEach(time => {
        const [start, end] = time;
        console.log(roomEndTimes);
        const roomIndex = roomEndTimes.findIndex(roomEndTime => roomEndTime <= start);
        console.log(roomIndex);
        if(roomIndex === -1) {
            roomEndTimes.push(end + 10);
        } else {
            roomEndTimes[roomIndex] = end + 10;
        }
    });
    return roomEndTimes.length;
}