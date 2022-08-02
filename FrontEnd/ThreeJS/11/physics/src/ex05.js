import * as THREE from 'three';
import * as CANNON from 'cannon-es';
import {OrbitControls} from "three/examples/jsm/controls/OrbitControls";
import {GLTFLoader} from "three/examples/jsm/loaders/GLTFLoader";
import {Domino} from "./Domino";


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

    // Loader
    const gltfLoader = new GLTFLoader();

    // Cannon
    const cannonWorld = new CANNON.World();
    cannonWorld.gravity.set(0, -10, 0);

    // Performance Setting
    cannonWorld.allowSleep = true;

    // Contact Material
    const defaultMaterial = new CANNON.Material('default');
    const defaultContactMaterial = new CANNON.ContactMaterial(
        defaultMaterial,
        defaultMaterial,
        {
            friction: 0.8,
            restitution: 0.3
        }
    );
    cannonWorld.defaultContactMaterial = defaultContactMaterial;

    const floorShape = new CANNON.Plane();
    const floorBody = new CANNON.Body({
        mass: 0,
        position: new CANNON.Vec3(0, 0, 0),
        shape: floorShape,
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

    // 도미노
    const dominos = [];
    let domino;
    for (let i = -10; i < 10; i++) {
        domino = new Domino({
            scene,
            cannonWorld,
            gltfLoader,
            z: -i * 0.8,
        });
        dominos.push(domino);
    }


    // 그리기
    const clock = new THREE.Clock();

    function draw() {
        const delta = clock.getDelta();

        cannonWorld.step(1 / 120, delta, 3);

        dominos.forEach(item => {
            if (item.cannonBody) {
                item.modelMesh.position.copy(item.cannonBody.position);
                item.modelMesh.quaternion.copy(item.cannonBody.quaternion);
            }
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

    // Raycaster
    const raycaster = new THREE.Raycaster();
    const mouse = new THREE.Vector2();

    function checkIntersects(){
        raycaster.setFromCamera(mouse, camera);
        const intersects = raycaster.intersectObjects(scene.children);
        if (intersects[0]?.object.cannonBody){
            intersects[0].object.cannonBody.applyForce(
                new CANNON.Vec3(0,0,-100),
                new CANNON.Vec3(0,0,0),
            )
        }
    }

    // 이벤트
    window.addEventListener('resize', setSize);
    window.addEventListener('click', (e) => {
        mouse.x = e.clientX / canvas.clientWidth * 2 -1;
        mouse.y = e.clientY / canvas.clientHeight * 2 -1;

        checkIntersects();
    });


    draw();
}
