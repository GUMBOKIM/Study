import {createMachine} from "xstate";

const GearRatio = {
    "N": 0,
    "1": 2,
    "2": 4,
    "3": 6,
    "4": 8,
    "5": 10,
}
const InitGearState = 'N'
const InitClutchState = 'On'


export const Transmission = createMachine({
        id: "Transmission",
        context: {
            gear: InitGearState,
            gearRatio: GearRatio[InitGearState]
        },
        initial: InitClutchState,
        states: {
            On: {
                on: {
                    ClutchOff: {
                        target: "Off"
                    }
                }
            },
            Off: {
                on: {
                    ClutchOn: {
                        target: "On"
                    },
                    GearChange: {
                        actions: "changeGear",
                    }
                }
            },
        }
    },
    {
        actions: {
            changeGear: (context, event) => {
                const targetGear = event.targetGear;
                context.gear = targetGear;
                context.gearRatio = GearRatio[targetGear];
            }
        }
    }
)