window.onload = () => {
    gsap.to('.stage > div', {y: -300, repeat: 2, stagger: {
            amount: 1,
            from: "center"
        }
    });
};