import {useMachine} from "@xstate/react";
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
            <button onClick={() => send("Monitoring")}>Monitoring</button>
        </>
    )
}


const CarDisplay = () => {

    return (
        <CarComponent/>
    )
}

export default CarDisplay;