import {createMachine} from "xstate";

const ClutchPedal = createMachine({
        id: "ClutchPedal",
        initial: 'Off',
        states: {
            On: {
                on: {
                    StepOff: {
                        target: "Off"
                    }
                }
            },
            Off: {
                on: {
                    StepOn: {
                        target: "On"
                    }
                }
            }
        }
    }
)

export default ClutchPedal;