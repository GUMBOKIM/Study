import {cm1 as cml, cm1, geo, mat} from "../common";
import {AnimationMixer, BoxGeometry, Mesh, MeshBasicMaterial} from "three";
import {Stuff} from "./Stuff";

export class Player extends Stuff {
    constructor(info) {
        super(info);

        this.mesh = new Mesh(
            new BoxGeometry(0.5,0.5,0.5),
            new MeshBasicMaterial({transparent: true, opacity: 0})
        );
        this.mesh.castShadow = true;
        this.mesh.position.set(this.x, this.y, this.z);
        cm1.scene.add(this.mesh);

        cm1.gltfLoader.load(
            '/models/ilbuni.glb',
            glb => {
                this.modelMesh = glb.scene.children[0];
                this.modelMesh.position.set(this.x, this.y, this.z);
                this.modelMesh.rotation.set(this.rotationX, this.rotationY, this.rotationZ);
                this.modelMesh.castShadow = true;
                cml.scene.add(this.modelMesh);

                this.modelMesh.animations = glb.animations;
                cml.mixer = new AnimationMixer(this.modelMesh);
                this.actions = [];
                this.actions[0] = cm1.mixer.clipAction(this.modelMesh.animations[0]); // default
                this.actions[1] = cm1.mixer.clipAction(this.modelMesh.animations[1]); // fall
                this.actions[2] = cm1.mixer.clipAction(this.modelMesh.animations[2]); // jump

                this.actions[0].play();
            }
        );

        // this.mesh = new Mesh(this.geometry, this.material);
        // this.mesh.position.set(this.x, this.y, this.z);
        // this.mesh.castShadow = true;
        // this.mesh.receiveShadow = true;
        // cm1.scene.add(this.mesh)
    }
}