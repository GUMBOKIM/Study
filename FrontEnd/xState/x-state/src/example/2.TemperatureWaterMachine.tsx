import {Typestate} from "xstate/lib/types";
import {createMachine, EventObject} from "xstate";
import React from "react";
import {useMachine} from "@xstate/react";

interface WaterMachineContext {
    temperature: number;
}

interface WaterMachineState extends Typestate<WaterMachineContext> {
    value: 'Ice' | 'Liquid' | 'Gas' | 'Plasma';
}

interface WaterMachineEvent extends EventObject {
    type: "Heat" | "Freeze";
}

const waterMachine = createMachine<WaterMachineContext, WaterMachineEvent, WaterMachineState>({
    id: "water",
    initial: "Liquid",
    context: {
        temperature: 0
    },
    states: {
        Ice: {
            on: {
                Heat: {
                    target: 'Liquid'
                }
            },
            entry: ['setIceTemperature'],
            exit: ['printEvent']
        },
        Liquid: {
            on: {
                Heat: {
                    target: 'Gas'
                },
                Freeze: {
                    target: 'Ice'
                }
            },
            entry: ['setLiquidTemperature'],
            exit: ['printEvent']
        },
        Gas: {
            on: {
                Heat: {
                    target: 'Plasma'
                },
                Freeze: {
                    target: 'Liquid'
                }
            },
            entry: ['setGasTemperature'],
            exit: ['printEvent']
        },
        Plasma: {
            on: {
                Freeze: 'Gas'
            },
            entry: ['setPlasmaTemperature'],
            exit: ['printEvent']
        }
    }
}, {
    actions: {
        setIceTemperature: (context) => {
            context.temperature = -10;
        },
        setLiquidTemperature: (context) => {
            context.temperature = 25;
        },
        setGasTemperature: (context) => {
            context.temperature = 100;
        },
        setPlasmaTemperature: (context) => {
            context.temperature = 600;
        },
        printEvent: (context, event, actionObject) => {
            console.log("context", context)
            console.log("event", event)
        }
    }
})

const BasicWaterMachine = () => {
    const [current, send] = useMachine(waterMachine);

    return (
        <>
            <h1>TemperatureWaterMachine</h1>
            <br/>
            <h2>{String(current.value)}</h2>
            <h3>{String(current.context.temperature)}</h3>

            <br/>
            <button onClick={() => send("Freeze")}>freeze</button>
            <button onClick={() => send("Heat")}>Heat</button>
        </>
    )
};


export default BasicWaterMachine;