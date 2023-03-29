window.onload = () => {
    const tl = gsap.timeline();

    tl.from('.sun', {duration: 1, opacity: 0, x: 50, y: 50});
    tl.from('.gress', {
        duration: 1, opacity: 0, y: 100, stagger: {
            each: 0.2, from: "center"
        }
    })
    tl.from('.bird', {duration: 1, opacity: 0, y: 100})
    tl.from('.music', {duration: 1, opacity: 0, x: 100, y: 100});
    tl.from('.eye-left', {duration: 1, x: 30, repeat: -1, yoyo: true});

}