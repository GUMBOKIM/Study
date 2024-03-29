import {cm1, geo, mat} from "../common";
import {Mesh} from "three";
import {Stuff} from "./Stuff";

export class Glass extends Stuff {
    constructor(info) {
        super(info);

        this.type = info.type;
        switch (this.type) {
            case 'normal':
                break;
            case 'strong':
                break;
        }

        this.geometry = geo.glass;
        this.material = mat.glass;

        this.mesh = new Mesh(this.geometry, this.material);
        this.mesh.position.set(this.x, this.y, this.z);
        this.mesh.castShadow = true;
        this.mesh.receiveShadow = true;
        cm1.scene.add(this.mesh)
    }
}