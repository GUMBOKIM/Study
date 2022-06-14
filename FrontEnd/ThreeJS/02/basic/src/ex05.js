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
    const draw = () => {
        mesh.rotation.y += THREE.MathUtils.degToRad(1);
        mesh.rotation.x += THREE.MathUtils.degToRad(1);
        if(mesh.position.z > 1 && mesh.position.z < 2) {
            mesh.position.z -= 0.1;
        }
        renderer.render(scene, camera);
        requestAnimationFrame(draw);
    }

    const setSize = () => {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.render((scene, camera));
    }

    window.addEventListener('resize', setSize)
    draw();
}


export const example5 = () => {PerspectiveCamera();}
