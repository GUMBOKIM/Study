window.onload = () => {
    document.addEventListener('click', function (event) {
        if (event.target.matches('button')) {
            event.target.focus()
        }
    })

    let tween = gsap.to('.orange', {x: 500, duration: 3});
    tween.pause();

    document.querySelector('.play').addEventListener('click', () => {
        tween.play()
    });
    document.querySelector('.pause').addEventListener('click', () => {
        tween.pause()
    });
    document.querySelector('.resume').addEventListener('click', () => {
        tween.resume()
    });
    document.querySelector('.reverse').addEventListener('click', () => {
        tween.reverse()
    });
    document.querySelector('.restart').addEventListener('click', () => {
        tween.restart()
    });
}