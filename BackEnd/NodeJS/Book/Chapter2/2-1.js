function first() {
    second();
    console.log('첫 번째')
}
function second() {
    third();
    console.log('두 번째')

}
function third() {
    console.log('세 번째')
}
first();


// * 호출스택 *
// LIFO 구조라서 anonymous -> first() -> second() -> third() 순으로 쌓임
// anonymous는 가상의 전역 컨텍스트 - 항상 있다고 생각하자!
// 함수 실행이 완료되면 메모리에서 빠진다.