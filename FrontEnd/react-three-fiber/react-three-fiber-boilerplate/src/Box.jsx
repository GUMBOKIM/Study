import {useRef, useState} from "react";
import {useFrame} from "@react-three/fiber";

export const Box = ({position, name, wireframe}) => {
    const [isExist, setIsExist] = useState(true);
    const meshRef = useRef();
    const materialRef = useRef();

    useFrame((state, delta) => {
        if (meshRef.current) {
            meshRef.current.rotation.x += 1 * delta;
            meshRef.current.rotation.y += 0.5 * delta;
            meshRef.current.position.y = (Math.sin(state.clock.getElapsedTime()) * 2) / 6;
        }
    });

    if (!isExist) return null;

    return (
        <mesh position={position} name={name} ref={meshRef}
              onPointerDown={(e) => setIsExist(false)}>
            <boxGeometry/>
            <meshBasicMaterial color={0x00ff00} wireframe={wireframe} ref={materialRef}/>
        </mesh>
    )
}