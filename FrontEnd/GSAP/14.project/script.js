window.onload = () => {
    const tl = gsap.timeline({ defaults:{opacity:0, ease:'back'}})

    function init(){
        tl.from('.stage',{ease:'linear',autoAlpha:0})
            .from('h1',{x:-50})
            .from('h2',{x:50},'<')
            .from('p',{x:-50},'-=0.2')
            .from('button',{y:30},'-=0.4')
            .from('.planet > img',{scale:0,stagger:0.1},'-=0.5')
    }

    init();
}