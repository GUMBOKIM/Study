window.onload = () => {
    gsap.to('.orange',
        {x: 300, repeat: 3, delay: 2, repeatDelay: 1, yoyo: true}
    );
};