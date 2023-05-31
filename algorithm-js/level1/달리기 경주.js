function solution(players, callings) {
    makeInfo(players);
    callings.forEach(call => {
        let idx = playerInfo[call];
        let frontPlayerName = players[idx - 1];

        players[idx] = players[idx - 1];
        players[idx - 1] = call;

        playerInfo[call] = idx - 1;
        playerInfo[frontPlayerName] = idx;
    });
    return players;
}

let playerInfo = {};

function makeInfo(players) {
    players.forEach((player, index) => {
        playerInfo[player] = index;
    })
}