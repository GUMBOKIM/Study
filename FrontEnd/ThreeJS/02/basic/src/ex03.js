import * as THREE from "three";

const PerspectiveCamera = () => {
    const canvas = document.querySelector('#three-canvas');
    const renderer = new THREE.WebGLRenderer({
        canvas,
        antialias: true,
        alpha: true
    });
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.setPixelRatio(window.devicePixelRatio);
    renderer.setClearColor('green');
    renderer.setClearAlpha(0.5);

    const scene = new THREE.Scene();
    scene.background = new THREE.Color('blue');

    const camera = new THREE.PerspectiveCamera(
        75,
        window.innerWidth / window.innerHeight,
        0.1,
        1000
    )
    camera.position.z = 5;
    camera.position.x = 1;
    camera.position.y = 2;
    scene.add(camera);

    const light = new THREE.DirectionalLight(0xffffff, 1);
    light.position.z = 2;
    light.position.x = 2;
    scene.add(light);

    const geometry = new THREE.BoxGeometry(1,1,1);
    const material = new THREE.MeshStandardMaterial({
        color: 'red'
    });

    const mesh = new THREE.Mesh(geometry, material);
    scene.add(mesh);
    renderer.render(scene, camera);

    const setSize = () => {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.render((scene, camera));
    }

    window.addEventListener('resize', setSize)
}


export const example3 = () => {PerspectiveCamera();}
