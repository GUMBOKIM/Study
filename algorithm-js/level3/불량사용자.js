const checkId = (userId, bannedId) => {
    let length = bannedId.length;
    if (userId.length !== length) {
        return false;
    } else {
        for (let i = 0; i < length; i++) {
            let userIdChar = userId[i];
            let banIdChar = bannedId[i];
            if (banIdChar !== "*" && userIdChar !== banIdChar) return false;
        }
    }
    return true;
}

function solution(userIds, bannedIds) {
    const bannedIdLength = bannedIds.length;
    const suspectsList = bannedIds.map(bannedId => userIds.filter(userId => checkId(userId, bannedId)));
    const result = [];
    const execute = (arr, index) => {
        if (index === bannedIdLength) {
            arr.sort();
            const findIndex = result.findIndex(el => {
                for (let i = 0; i < bannedIdLength; i++) {
                    if (el[i] !== arr[i]) return false;
                }
                return true;
            })
            if (findIndex === -1) result.push(arr);
        } else {
            const suspects = suspectsList[index];
            suspects.forEach(suspect => {
                if (!arr.includes(suspect)) {
                    execute([...arr, suspect], index + 1);
                }
            })
        }
    }
    execute([], 0);
    return result.length;
}