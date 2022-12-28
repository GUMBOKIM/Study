import {assign, createMachine} from "xstate";


const Engine = createMachine({
    id: "Engine",
    context: {
        rpm: 0
    },
    initial: "Off",
    states: {
        Off: {
            on: {
                TurnOn: {
                    target: "PrepareOn"
                },
            },
            entry: assign({
                rpm: 0
            })
        },
        PrepareOn: {
            after: {
                1000: {
                    target: 'On',
                }
            },
            entry: assign({
                rpm: 100
            })
        },
        On: {
            on: {
                TurnOff: {
                    target: "PrepareOff"
                }
            },
            entry: assign({
                rpm: 1000
            })
        },
        PrepareOff: {
            after: {
                1000: {
                    target: 'Off',
                }
            },
            entry: assign({
                rpm: 500
            })
        }
    }
});


export default Engine;