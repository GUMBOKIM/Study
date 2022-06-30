import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
  const [counter, setCounter] = useState(0);

  return (
    <div className="App">
      <header className="App-header">
        <h3 data-testid="counter">{counter}</h3>
          <button onClick={() => setCounter((count) => count - 1)} data-testid="minus-button">-</button>
          <button onClick={() => setCounter((count) => count + 1)} data-testid="plus-button">+</button>
      </header>
    </div>
  );
}

export default App;
