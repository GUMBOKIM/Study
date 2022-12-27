import React from 'react';
import BasicWaterMachine from "./example/1.BasicWaterMachine";
import TemperatureWaterMachine from "./example/2.TemperatureWaterMachine";
import BasicEngine from "./example/3.BasicEngine";
import RpmEngine from "./example/4.RpmEngine";

function App() {

    return (
        <div>
            <BasicWaterMachine/>
            <hr/>
            <TemperatureWaterMachine/>
            <hr/>
            <BasicEngine/>
            <hr/>
            <RpmEngine/>
        </div>
    );
}

export default App;
