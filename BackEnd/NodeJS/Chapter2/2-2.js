function run() {
    console.log('3초후 실행')
}
console.log('시작')
setTimeout(run, 3000);
console.log('끝')

// 시작 -> 끝 -> 3초후 실행
// Why? setTimeout은 비동기라서!
// 자바스크립트 이벤트 루프
// 호출 스택 / 백그라운 / 태스크큐 / 메모리 
