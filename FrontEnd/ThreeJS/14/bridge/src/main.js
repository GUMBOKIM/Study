import * as THREE from 'three';
import {OrbitControls} from 'three/examples/jsm/controls/OrbitControls';
import {cm1, cm2} from "./common";
import {Pillar} from "./object/Pillar";
import {Floor} from "./object/Floor";
import {Bar} from "./object/Bar";
import {SideLight} from "./object/SideLight";
import {Glass} from "./object/Glass";
import {Player} from "./object/Player";

// ----- 주제: The Bridge 게임 만들기

// Renderer
const renderer = new THREE.WebGLRenderer({
    canvas: cm1.canvas,
    antialias: true
});
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.setPixelRatio(window.devicePixelRatio > 1 ? 2 : 1);
renderer.shadowMap.enabled = true;
renderer.shadowMap.type = THREE.PCFSoftShadowMap;

// Scene
const scene = cm1.scene;
cm1.scene.background = new THREE.Color(cm2.backgroundColor);

// Camera
const camera = new THREE.PerspectiveCamera(
    75,
    window.innerWidth / window.innerHeight,
    0.1,
    1000
);
camera.position.x = -4;
camera.position.y = 19;
camera.position.z = 14;
scene.add(camera);

// Light
const ambientLight = new THREE.AmbientLight('white', 0.5);
scene.add(ambientLight);

const spotLightDistance = 50;
const spotLight1 = new THREE.SpotLight(cm2.lightColor, 2);
const spotLight2 = spotLight1.clone();
const spotLight3 = spotLight1.clone();
const spotLight4 = spotLight1.clone()
spotLight1.position.set(-spotLightDistance, spotLightDistance, spotLightDistance);
spotLight1.shadow.width = 2048;
spotLight1.shadow.height = 2048;
spotLight2.position.set(spotLightDistance, spotLightDistance, -spotLightDistance);
spotLight2.shadow.width = 2048;
spotLight2.shadow.height = 2048;
spotLight3.position.set(-spotLightDistance, spotLightDistance, -spotLightDistance);
spotLight3.shadow.width = 2048;
spotLight3.shadow.height = 2048;
spotLight4.position.set(spotLightDistance, spotLightDistance, spotLightDistance);
spotLight4.shadow.width = 2048;
spotLight4.shadow.height = 2048;
scene.add(spotLight1, spotLight2, spotLight3, spotLight4);

// Controls
const controls = new OrbitControls(camera, renderer.domElement);
controls.enableDamping = true;

// 물체 만들기
const glassUnitSize = 1.2;
const numberOfGlass = 10;

// 바닥
const floor = new Floor({
    name: 'floor'
})

// 기둥
const pillar1 = new Pillar({
    name: 'pillar',
    x: 0,
    y: 5.5,
    z: -glassUnitSize * 12 - glassUnitSize / 2
});

const pillar2 = new Pillar({
    name: 'pillar',
    x: 0,
    y: 5.5,
    z: glassUnitSize * 12 + glassUnitSize / 2
})

// 바

const bar1 = new Bar({name: 'bar', x: -1.6, y: 10.3, z: 0});
const bar2 = new Bar({name: 'bar', x: -0.4, y: 10.3, z: 0});
const bar3 = new Bar({name: 'bar', x: 0.4, y: 10.3, z: 0});
const bar4 = new Bar({name: 'bar', x: 1.6, y: 10.3, z: 0});

// 유리
for(let i = 0; i < numberOfGlass; i++) {
    let glassTypes;
    const glassTypeNumber = Math.round(Math.random());
    switch (glassTypeNumber) {
        case 0:
            glassTypes = ['normal', 'strong'];
            break;
        case 1:
            glassTypes = ['strong', 'normal'];
            break;
    }
    const glass1 = new Glass({
        name: 'glass',
        x: -1,
        y: 10.5,
        z: i * glassUnitSize * 2 - glassUnitSize * 9,
        type: glassTypes[0]
    })

    const glass2 = new Glass({
        name: 'glass',
        x: 1,
        y: 10.5,
        z: i * glassUnitSize * 2 - glassUnitSize * 9,
        type: glassTypes[1]
    })
}


for (let i = 0; i < 49; i++) {
    new SideLight({
        name: 'sideLight',
        container: bar1.mesh,
        z: i * 0.5 - glassUnitSize * 10
    })
    new SideLight({
        name: 'sideLight',
        container: bar4.mesh,
        z: i * 0.5 - glassUnitSize * 10
    })
}
// 플레이어
new Player({
    name: 'player',
    x: 0,
    y: 10.9,
    z: 13,
    rotationY: Math.PI
    }
);


// 그리기
const clock = new THREE.Clock();

function draw() {
    const delta = clock.getDelta();

    if(cm1.mixer) cm1.mixer.update(delta);

    controls.update();

    renderer.render(scene, camera);
    renderer.setAnimationLoop(draw);
}

function setSize() {
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.render(scene, camera);
}

// 이벤트
window.addEventListener('resize', setSize);

draw();