import {createMachine} from "xstate";

export const AcceleratePedal = createMachine({
        id: "AcceleratePedal",
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