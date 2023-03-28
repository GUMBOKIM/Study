window.onload = () => {
    gsap.to('.orange',
        {duration:3, repeat: -1, x: 600}
    );
    gsap.to('.pink',
        {duration:3, repeat: -1, x: 600, ease: Power3.easeIn}
    );
};