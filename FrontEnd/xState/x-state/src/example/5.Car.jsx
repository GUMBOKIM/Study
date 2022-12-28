import {useMachine} from "@xstate/react";
import {Transmission} from "./5.Car/Transmission";
import Engine from "./5.Car/Engine";
import Car from "./5.Car/Car";

const CarComponent = () => {
    const [current, send] = useMachine(Car);

    return (
        <>
            <h1>Car</h1>
            <h2>Car State : {current.value}</h2>
            <button onClick={() => send("TurnOn")}>TurnOn</button>
            <button onClick={() => send("TurnOff")}>TurnOff</button>
            <button onClick={() => send("PushAccelPedal")}>Accel</button>
        </>
    )
}


const TransmissionComponent = () => {
    const [current, send] = useMachine(Transmission);

    return (
        <>
            <h1>Transmission</h1>
            <h3>Gear Ratio : {current.context.gearRatio}</h3>
            <hr/>
            <h2>Gear State : {current.context.gear}</h2>
            {
                ["N", 1, 2, 3, 4, 5].map(gear => <button key={gear}
                                                         onClick={() => send("GearChange", {targetGear: gear})}>
                    {gear}
                </button>)
            }

            <hr/>
            <h2>Clutch State : {current.value}</h2>
            <button onClick={() => send("ClutchOn")}>ClutchOn</button>
            <button onClick={() => send("ClutchOff")}>ClutchOff</button>
        </>
    )
}

const EngineComponent = () => {
    const [current, send] = useMachine(Engine);

    return (
        <>
            <h1>Engine</h1>
            <h2>Engine State : {current.value}</h2>
            <h3>Rpm : {current.context.rpm}</h3>
            <hr/>
            <button onClick={() => send("TurnOn")}>TurnOn</button>
            <button onClick={() => send("TurnOff")}>TurnOff</button>
        </>
    )
}


const CarDisplay = () => {

    return (
        <>
            <CarComponent/>
            <hr/>
            <EngineComponent/>
            <hr/>
            <TransmissionComponent/>
        </>
    )
}

export default CarDisplay;