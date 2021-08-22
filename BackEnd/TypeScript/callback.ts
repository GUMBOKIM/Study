// 익명 callback 함수 타입, callback 함수의 가독성을 위해서 사용 합니다
type callBackType = (mesasge: string) => void ;

// 익명 콜백 함수
let crazy: callBackType = meessage => {
    return "cray!!!";
};

// 익명 콜백 함수
let sad: callBackType = meessage => {
    return "sad ㅠ.ㅠ";
};
// 콜백 함수를 실행 할 함수
function callfunc(message: string, callback) {
    return "I am " + callback(message);
}

// cray 콜백 함수를 인자로 주어 함수 실행
let result1 = callfunc("hello", crazy);
console.log(result1);

// sad 콜백 함수를 인자로 주어 함수 실행
let result2 = callfunc("hello", sad);
console.log(result2);

