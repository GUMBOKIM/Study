import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
    const [counter, setCounter] = useState(0);
    const [isDisable, setIsDisable] = useState(false);

    return (
        <div className="App">
            <header className="App-header">
                <h3 data-testid="counter">{counter}</h3>
                <button onClick={() => setCounter((count) => count - 1)} data-testid="minus-button"
                        disabled={isDisable}>-
                </button>
                <button onClick={() => setCounter((count) => count + 1)} data-testid="plus-button"
                        disabled={isDisable}>+
                </button>
                <button data-testid="on/off-button" style={{backgroundColor: "blue"}}
                        onClick={() => setIsDisable((prev) => !prev)}>
                    on/off
                </button>
            </header>
        </div>
    );
}

export default App;
