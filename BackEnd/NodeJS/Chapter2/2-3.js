function oneMore() {
    console.log("OneMore");
}

function run() {
    console.log("Running")
    setTimeout(() => {
        console.log("wow")
    }, 0);
    new Promise((resolve) => {
        resolve('hi')
    }).then(console.log);
    oneMore();
}

setTimeout(run, 5000);

// 태스크 큐에 들어가는 것은 똑같지만 우선순위 때문에 Promise.then이 먼저 실행됨 