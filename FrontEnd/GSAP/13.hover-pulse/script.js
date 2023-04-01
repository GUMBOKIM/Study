window.onload = () => {


    const button = document.querySelector('.button');

    const scaleTween = gsap.to('.button',{scale:1,yoyo:true,repeat:15,paused:true});


    button.addEventListener('mouseenter',()=>{scaleTween.restart()})
    button.addEventListener('mouseleave',()=>{
        scaleTween.pause();
        gsap.to('.button',{scale:0.8})
    })


}