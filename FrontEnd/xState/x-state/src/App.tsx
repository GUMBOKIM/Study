import React from 'react';
import BasicWaterMachine from "./example/1.BasicWaterMachine";
import TemperatureWaterMachine from "./example/2.TemperatureWaterMachine";

function App() {

    return (
        <div>
            <BasicWaterMachine/>
            <hr/>
            <TemperatureWaterMachine/>
        </div>
    );
}

export default App;
