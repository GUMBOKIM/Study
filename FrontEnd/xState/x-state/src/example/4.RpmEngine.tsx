import {Typestate} from "xstate/lib/types";
import {assign, createMachine, EventObject} from "xstate";
import {useMachine} from "@xstate/react";


const RPM_IDLE = 1000;
const RPM_MAX = 10000;

interface EngineContext {
    rpm: number;
}

interface EngineState extends Typestate<EngineContext> {
    value: 'Off' | 'PrepareOn' | 'On' | 'PrepareOff';
}

interface EngineEvent extends EventObject {
    type: "TurnOn" | "TurnOff" | "Idling" | "Accelerating" | "EngineOn" | "EngineOff";
}

const engineMachine = createMachine<EngineContext, EngineEvent, EngineState>({
        id: "engine",
        initial: 'Off',
        context: {
            rpm: 0
        },
        states: {
            Off: {
                on: {
                    TurnOn: {
                        target: 'PrepareOn',
                    }
                },
                entry: assign({
                    rpm: 0
                })
            },
            PrepareOn: {
                invoke: {
                    id: "PrepareOnInterval",
                    src: () => (callback, onReceive) => {
                        const id = setInterval(() => callback('EngineOn'), 200);
                        return () => clearInterval(id);
                    }
                },
                after: {
                    ENGINE_PREPARE_TIME: {
                        target: 'On',
                    }
                },
                on: {
                    EngineOn: {
                        actions: assign({
                                rpm: ({rpm}: EngineContext) => rpm + 100
                            }
                        )
                    }
                }
            },
            On: {
                invoke: {
                    id: "IdleInterval",
                    src: () => (callback, onReceive) => {
                        const id = setInterval(() => callback('Idling'), 300);
                        return () => clearInterval(id);
                    }
                },
                on: {
                    TurnOff: {
                        target: 'PrepareOff',
                    },
                    Idling: {
                        actions: assign({
                                rpm: ({rpm}: EngineContext, event) => Math.floor(rpm + Math.min((RPM_IDLE - rpm) / 2, 200) + (0.5 - Math.random()) * 10)
                            }
                        )
                    },
                    Accelerating: {
                        actions: assign({
                            rpm: ({rpm}: EngineContext) => rpm + 1500 > RPM_MAX ? RPM_MAX : rpm + 1500
                        })
                    }
                },
            },
            PrepareOff: {
                invoke: {
                    id: "PrepareOffInterval",
                    src: () => (callback, onReceive) => {
                        const id = setInterval(() => callback('EngineOff'), 100);
                        return () => clearInterval(id);
                    }
                },
                after: {
                    ENGINE_PREPARE_TIME: {
                        target: 'Off',
                    }
                },
                on: {
                    EngineOff: {
                        actions: assign({
                                rpm: ({rpm}: EngineContext) => rpm < 100 ? 0 : Math.floor(rpm / 3)
                            }
                        )
                    }
                }
            }
        }
    },
    {
        delays: {
            ENGINE_PREPARE_TIME: 500
        }
    }
)

const RpmEngine = () => {
    const [current, send] = useMachine(engineMachine);

    return (
        <>
            <h1>TachometerEngine</h1>
            <br/>
            <h2>Engine State : {current.value as string}</h2>
            <h3>Rpm : {current.context.rpm}</h3>
            <br/>
            <button onClick={() => send('TurnOn')}>turn on</button>
            <button onClick={() => send('TurnOff')}>turn off</button>
            <button onClick={() => {
                send('Accelerating')
                console.log('ACCe')
            }}>Accelerating
            </button>
        </>
    )
}

export default RpmEngine;