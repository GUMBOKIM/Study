import {Typestate} from "xstate/lib/types";
import {createMachine, EventObject} from "xstate";
import React from "react";
import {useMachine} from "@xstate/react";

interface WaterState extends Typestate<null> {
    value: 'Ice' | 'Liquid' | 'Gas' | 'Plasma';
}

interface FreezeEvent extends EventObject {
    type: "Freeze";
}

interface HeatEvent extends EventObject {
    type: "Heat";
}

type Event = FreezeEvent | HeatEvent

const waterMachine = createMachine<null, Event, WaterState>({
    id: "water",
    initial: "Liquid",
    states: {
        Ice: {
            on: {
                Heat: {
                    target: 'Liquid'
                }
            }
        },
        Liquid: {
            on: {
                Heat: {
                    target: 'Gas'
                },
                Freeze: {
                    target: 'Ice'
                }
            }
        },
        Gas: {
            on: {
                Heat: {
                    target: 'Plasma'
                },
                Freeze: {
                    target: 'Liquid'
                }
            }
        },
        Plasma: {
            on: {
                Freeze: 'Gas'
            }
        }
    }
})

const BasicWaterMachine = () => {
    const [current, send] = useMachine(waterMachine);

    return (
        <>
            <h1>BasicWaterMachine</h1>
            <br/>
            <h2>{String(current.value)}</h2>
            <br/>
            <button onClick={() => send("Freeze")}>freeze</button>
            <button onClick={() => send("Heat")}>Heat</button>
        </>
    )
};


export default BasicWaterMachine;