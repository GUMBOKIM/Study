import * as THREE from 'three';
import * as CANNON from 'cannon-es';
import {OrbitControls} from "three/examples/jsm/controls/OrbitControls";
import {MySphere} from "./mySphere";
import {color} from "three/examples/jsm/nodes/shadernode/ShaderNodeBaseElements";

// ----- 주제: cannon.js 기본 세팅

// cannon.js 문서
// http://schteppe.github.io/cannon.js/docs/
// 주의! https 아니고 http

export default function example() {
    // Renderer
    const canvas = document.querySelector('#three-canvas');
    const renderer = new THREE.WebGLRenderer({
        canvas,
        antialias: true
    });
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.setPixelRatio(window.devicePixelRatio > 1 ? 2 : 1);
    renderer.shadowMap.enabled = true;
    renderer.shadowMap.type = THREE.PCFSoftShadowMap;

    // Scene
    const scene = new THREE.Scene();

    // Camera
    const camera = new THREE.PerspectiveCamera(
        75,
        window.innerWidth / window.innerHeight,
        0.1,
        1000
    );
    camera.position.y = 1.5;
    camera.position.z = 4;
    scene.add(camera);

    // Light
    const ambientLight = new THREE.AmbientLight('white', 0.5);
    scene.add(ambientLight);

    const directionalLight = new THREE.DirectionalLight('white', 1);
    directionalLight.position.x = 1;
    directionalLight.position.z = 2;
    directionalLight.castShadow = true;
    scene.add(directionalLight);

    // Controls
    const controls = new OrbitControls(camera, renderer.domElement);

    // Cannon
    const cannonWorld = new CANNON.World();
    cannonWorld.gravity.set(0, -10, 0);

    // Performance Setting
    cannonWorld.allowSleep = true;

    // Contact Material
    const defaultMaterial = new CANNON.Material('default');
    const rubberMaterial = new CANNON.Material('rubber');
    const ironMaterial = new CANNON.Material('iron');
    const defaultContactMaterial = new CANNON.ContactMaterial(
        defaultMaterial,
        defaultMaterial,
        {
            friction: 0,
            restitution: 0
        }
    );
    cannonWorld.defaultContactMaterial = defaultContactMaterial;

    const rubberDefaultContactMaterial = new CANNON.ContactMaterial(
        rubberMaterial,
        defaultMaterial,
        {
            friction: 0.8,
            restitution: 0.7
        }
    );
    cannonWorld.addContactMaterial(rubberDefaultContactMaterial);


    const floorShape = new CANNON.Plane();
    const floorBody = new CANNON.Body({
        mass: 0,
        position: new CANNON.Vec3(0, 0, 0),
        shape: floorShape,
        material: defaultMaterial,
    });
    floorBody.quaternion.setFromAxisAngle(
        new CANNON.Vec3(-1, 0, 0),
        Math.PI / 2
    )
    cannonWorld.addBody(floorBody);


    // Mesh
    const floorMesh = new THREE.Mesh(
        new THREE.PlaneGeometry(10, 10),
        new THREE.MeshStandardMaterial({
            color: 'slategray'
        })
    );
    floorMesh.rotateX(-Math.PI / 2);
    floorMesh.receiveShadow = true;
    scene.add(floorMesh);

    let spheres = [];
    const sphereGeometry = new THREE.SphereGeometry(0.5);
    const sphereMaterial = new THREE.MeshStandardMaterial({
        color: 'seagreen'
    });

    // 그리기
    const clock = new THREE.Clock();

    function draw() {
        const delta = clock.getDelta();

        cannonWorld.step(1 / 120, delta, 3);

        spheres.forEach(item => {
            item.mesh.position.copy(item.cannonBody.position);
            item.mesh.quaternion.copy(item.cannonBody.quaternion);
        })

        renderer.render(scene, camera);
        renderer.setAnimationLoop(draw);
    }

    function setSize() {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.render(scene, camera);
    }

    const sound = new Audio('/sounds/boing.mp3');

    function collide(e) {
        const velocity = e.contact.getImpactVelocityAlongNormal();
        if (velocity > 3) {
            sound.currentTime = 0;
            sound.play();
        }
    }

    // 이벤트
    window.addEventListener('resize', setSize);
    window.addEventListener('click', (event) => {
        if (event.target !== event.currentTarget) {
            for (let i = 0; i < 10; i++) {
                const mySphere = new MySphere({
                    scene,
                    cannonWorld,
                    geometry: sphereGeometry,
                    material: sphereMaterial,
                    x: (Math.random() - 0.5) * 2,
                    y: Math.random() * 5 + 2,
                    z: (Math.random() - 0.5) * 2,
                    scale: Math.random() + 0.2,
                });
                spheres.push(mySphere);
                console.log(spheres.length)
                mySphere.cannonBody.addEventListener('collide', collide);
            }
        }
    });

    const btn = document.createElement('button');
    btn.style.cssText = 'position: absolute; left: 20px; top: 20px; font-size: 20px';
    btn.innerHTML = '삭제';
    document.body.append(btn);

    btn.addEventListener('click', () => {
        spheres.forEach(item => {
            item.cannonBody.removeEventListener('collide', collide);
            scene.remove(item.mesh);
            cannonWorld.removeBody(item.cannonBody);
        })
    });

    draw();
}
