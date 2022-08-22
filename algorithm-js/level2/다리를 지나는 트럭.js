function solution(bridge_length, weight, truck_weights) {
    truck_weights.reverse();
    let answer = 0;

    let nowTruck = 0;
    let bridgeWeight = 0;
    let bridge = new Array(bridge_length).fill(0);

    const move = input => {
        let last = bridge[bridge_length - 1];
        bridge = [input, ...bridge.slice(0, bridge_length - 1)]
        bridgeWeight -= last;
    }

    const addCheck = input =>  bridgeWeight + input <= weight;

    while(nowTruck < truck_weights.length){
        let weight = truck_weights[nowTruck];
        if(addCheck(weight)) {
            move(weight);
            bridgeWeight += weight;
            nowTruck ++;
        } else {
            move(0);
        }
        if(bridgeWeight != 0) answer ++;
    }

    return answer + bridge_length;
}

console.log(solution(2, 10, [7, 4, 5, 6]))