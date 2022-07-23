import * as THREE from 'three';
import {OrbitControls} from 'three/examples/jsm/controls/OrbitControls';
import dat from 'dat.gui';

// ----- 주제: 

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
    renderer.shadowMap.type = THREE.BasicShadowMap;

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
    scene.add(ambientLight)

    const light = new THREE.SpotLight('red', 1, 100, Math.PI / 4);
    light.position.y = 3;
    scene.add(light)

    light.castShadow = true;
    light.shadow.mapSize.width = 100;
    light.shadow.mapSize.height = 100;

    const lightHelper = new THREE.SpotLightHelper(light);
    scene.add(lightHelper);



    // Controls
    const controls = new OrbitControls(camera, renderer.domElement);

    // Geometry
    const planeGeometry = new THREE.PlaneGeometry(10, 10);
	const boxGeometry = new THREE.BoxGeometry(1, 1, 1);
	const sphereGeometry = new THREE.SphereGeometry(0.7, 16, 16);

    // Material
    const material1 = new THREE.MeshStandardMaterial({color: 'white'});
	const material2 = new THREE.MeshStandardMaterial({color: 'royalblue'});
	const material3 = new THREE.MeshStandardMaterial({color: 'gold'});

    // Mesh
    const planeMesh = new THREE.Mesh(planeGeometry, material1);
	const boxMesh = new THREE.Mesh(boxGeometry, material2);
	const sphereMesh = new THREE.Mesh(sphereGeometry, material3);

    planeMesh.rotation.x = -Math.PI * 0.5;
    boxMesh.position.set(1,1,0);
    sphereMesh.position.set(-1,1,0);

    planeMesh.receiveShadow = true;
    boxMesh.castShadow = true;
    boxMesh.receiveShadow = true;
    sphereMesh.castShadow = true;
    sphereMesh.receiveShadow = true;

   scene.add(planeMesh, boxMesh, sphereMesh);

    // AxesHelper
    const axesHelper = new THREE.AxesHelper(3);
    scene.add(axesHelper);

    // Dat GUI
    const gui = new dat.GUI();
    gui.add(light.position, 'x', -5, 5, 0.1).name('카메라 X');
    gui.add(light.position, 'y', -5, 5, 0.1).name('카메라 Y');
    gui.add(light.position, 'z', -5, 5, 0.1).name('카메라 Z');

    // 그리기
    const clock = new THREE.Clock();

    function draw() {
        const delta = clock.getDelta();

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
}