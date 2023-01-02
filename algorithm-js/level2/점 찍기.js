function solution(k, d) {
    // 찍힌 점의 수를 알아내는 변수
    let countStar = 0

    // x² + y² = d² 인 것을 활용해서 y² = d² - x² 을 통해 y²값 도출
    function getY(num) {
        return Math.sqrt(d ** 2 - num ** 2)
    }

    // y²값을 활용하여 루트 y/k로 현재 증가량의 값 중 찍을 수 있는 최대 점의 수 확인
    for (let i = 0; i <= d; i += k) {
        countStar += Math.floor(getY(i) / k) + 1
    }
    return countStar
}
