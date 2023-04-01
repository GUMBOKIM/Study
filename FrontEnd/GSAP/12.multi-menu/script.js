window.onload = () => {

    const items = document.querySelectorAll('.item');

    items.forEach((item) => {
        let tl = gsap.timeline({paused: true});
        tl.to(item.querySelector('.text'), {color: "#fff", x: 15})
        tl.to(item.querySelector('.dash'), {opacity: 1, x: -5, backgroundColor: "yellow"}, 0);
        item.addEventListener('mouseenter', () => {
            tl.play()
        })
        item.addEventListener('mouseleave', () => {
            tl.reverse()
        })
    })
}