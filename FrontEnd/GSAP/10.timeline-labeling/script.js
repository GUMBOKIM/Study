window.onload = () => {
    let tl = gsap.timeline({paused:true});


    tl.from('.sun',{duration:3,opacity:0,x:50,y:50})
    tl.from('.land',{duration:1,opacity:0},'-=1.5')
    tl.from('.gress',{duration:1,opacity:0,y:100,stagger:{
            each:0.2,
            from:"center"
        }})
    tl.add('test')
    tl.from('.bird',{duration:1,opacity:0,y:100},'<')
    tl.from('.music',{duration:1,opacity:0,x:100,y:100},3)
    tl.from('.eye-left,.eye-right',{duration:1,x:30,repeat:-1,yoyo:true})
    tl.to('.mouse',{scaleY:0,transformOrigin:'center center',repeat:-1,yoyo:true},'<')

    function hasClass(className){
        return event.target.classList.contains(className)
    }


    document.addEventListener('click', function (event) {
        let check = event.target.classList;

        if (event.target.matches('button')) { event.target.focus()}


        if(hasClass('play')){ tl.play() }

        if(hasClass('pause')){ tl.pause() }

        if(hasClass('reverse')){ tl.reverse() }

        if(hasClass('restart')){ tl.restart() }

        if(hasClass('test')){ tl.play('test') }

    })
}