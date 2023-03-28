window.onload = () => {
    gsap.from('.orange',
        {duration: 3, x: 300, y: 300, scale: 3, rotation: 360},
        {duration: 10, x: 100, y: 300, scale: 2, backgroundColor: "red", rotation: 360}
    );
};