import {Typestate} from "xstate/lib/types";
import {createMachine, EventObject} from "xstate";
import {useMachine} from "@xstate/react";

interface EngineState extends Typestate<null> {
    value: 'Stop' | 'Preparing' | 'Running';
}

interface EngineEvent extends EventObject {
    type: "TurnOn" | "TurnOff";
}

const engineMachine = createMachine<null, EngineEvent, EngineState>({
        id: "engine",
        initial: 'Stop',
        states: {
            Stop: {
                on: {
                    TurnOn: {
                        target: 'Preparing',
                    }
                },
            },
            Preparing: {
                after: {
                    500: {
                        target: 'Running'
                    }
                }
            },
            Running: {
                on: {
                    TurnOff: {
                        target: 'Stop'
                    }
                },
            },
        }
    }
)

const BasicEngine = () => {
    const [current, send] = useMachine(engineMachine);

    return (
        <>
            <h1>BasicEngine</h1>
            <br/>
            <h2>Engine State : {current.value as string}</h2>
            <br/>
            <button onClick={() => send('TurnOn')}>turn on</button>
            <button onClick={() => send('TurnOff')}>turn off</button>
        </>
    )
}

export default BasicEngine;