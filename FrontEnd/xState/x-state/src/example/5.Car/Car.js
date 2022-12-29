import {createMachine, send} from "xstate";
import Engine from "./Engine";
import {Transmission} from "./Transmission";

const Car = createMachine({
        id: "Car",
        context: {
            speed: 0
        },
        initial: "Off",
        invoke: [
            {
                id: "Engine",
                src: Engine
            },
            {
                id: "Transmission",
                src: Transmission,
                data: {}
            }
        ],
        states: {
            Off: {
                on: {
                    TurnOn: {
                        target: "On",
                    }
                },
                entry: [
                    send({type: "TurnOff"}, {to: "Engine"})
                ]
            },
            On: {
                entry: [
                    send({type: "TurnOn"}, {to: "Engine"})
                ],
                on: {
                    TurnOff: {
                        target: "Off"
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
                        },
                    },
                },
            }
        },
        on: {
            Monitoring: {
                actions: (context, event, meta) => {
                    console.log("Monitoring");
                    console.log(meta.state.children.Engine._state.context);
                    console.log("Monitoring");
                }
            }
        }
    },
    {
        actions: {
            Monitoring: () => {

            }
        }
    }
)

export default Car;