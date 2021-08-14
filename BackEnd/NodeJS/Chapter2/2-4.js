// var VS let, const -> 스코프 차이
// const는 '='을 딱한번만 가능하다.


if (true) {
    var x = 3;
}
console.log(x);

if (true) {
    const y = 3;
}
console.log(y)
// const는 블록 스코프를 못빠져나가서 에러가 발생

function a(){
    var z = 3;
}
console.log(z);
// var은 function 스코프를 못빠져나가서 에러가 발생
