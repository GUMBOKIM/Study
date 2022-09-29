function solution(user_id, banned_id) {
    var answer = 0;
    return answer;
}


const checkId = (userId, bannedId) => {
    let length = bannedId.length;
    if(userId.length !== length) {
        return false;
    } else {
        for (let i = 0; i < length; i++) {
            let userIdChar = userId[i];
            let banIdChar = bannedId[i];
            if(banIdChar !== "*" && userIdChar !== banIdChar) return false;
        }
    }
    return true;
}

console.log(checkId("frodo", "frd*"))