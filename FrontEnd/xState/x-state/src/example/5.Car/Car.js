import {createMachine, send} from "xstate";
import Engine from "./Engine";
import {Transmission} from "./Transmission";
import ClutchPedal from "./ClutchPedal";
import {AcceleratePedal} from "./AcceleratePedal";

const Car = createMachine({
        id: "Car",
        context: {
            speed: 0
        },
        initial: "Off",
        states: {
            Off: {
                on: {
                    TurnOn: {
                        target: "On",
                        actions: [(context, event, meta) => {
                            console.log(meta.state.children.Engine);
                            send((context, event) => (
                                {type: 'TurnOn'}
                            ), {to: 'Engine'})
                        }]
                    }
                }
            },
            On: {
                entry: (context, event, meta) => {
                    console.log(meta.state.children.Engine);
                },
                on: {
                    TurnOff: {
                        target: "Off",
                    },
                    PushAccelPedal: {
                        actions: (context, event, meta) => {
                            console.log(context);
                            console.log(event);
                            console.log(meta);
                        }
                    },
                    ReleaseAccelPedal: {
                        actions: (context, event, meta) => {
                            console.log(context);
                            console.log(event);
                            console.log(meta);
                        }
                    },
                    PushClutchPedal: {
                        actions: (context, event, meta) => {
                            console.log(context);
                            console.log(event);
                            console.log(meta);
                        }
                    },
                    ReleaseClutchPedal: {
                        actions: (context, event, meta) => {
                            console.log(context);
                            console.log(event);
                            console.log(meta);
                        }
                    },
                },
            }
        },
        invoke: [
            {
                id: "Engine",
                src: Engine
            },
            {
                id: "Transmission",
                src: Transmission,
            },
            {
                id: "ClutchPedal",
                src: ClutchPedal
            },
            {
                id: "AcceleratePedal",
                src: AcceleratePedal
            }
        ]
    }
)

export default Car;