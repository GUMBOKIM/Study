let length;
let answer = []

function solution(tickets) {
    length = tickets.length;
    const visited = Array(length).fill(false)
    dfs("ICN", visited, tickets, 0, ["ICN"]);
    answer.sort((routes1, routes2) => {
        for (let i = 1; i <= length; i++) {
            if(routes1[i] !== routes2[i]) {
                return routes1[i] > routes2[i] ? 1: -1;
            }
        }
        return 0;
    })
    return answer[0];
}

const dfs = (origin, visited, tickets, count, routes) => {
    if(count === length) {
        answer.push([...routes]);
    } else {
        for (let i = 0; i < length; i++) {
            let [ticketOrigin, ticketDestination] = tickets[i];
            if(!visited[i] && ticketOrigin === origin) {
                visited[i] = true;
                routes.push(ticketDestination);
                dfs(ticketDestination, visited, tickets, count + 1, routes);
                routes.pop();
                visited[i] = false;
            }
        }
    }
}

console.log(solution(	[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]));