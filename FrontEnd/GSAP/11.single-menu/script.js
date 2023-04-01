window.onload = () => {
    const item = document.querySelector('.item');

    let tl = gsap.timeline({paused: true});
    tl.to('.dash', {opacity: 1, backgroundColor: 'yellow'})
        .to('.text', {x: 5, color: 'white'}, '<');

    item.addEventListener('mouseenter', () => {
        tl.play()
    });
    item.addEventListener('mouseleave', () => {
        tl.reverse()
    });
}