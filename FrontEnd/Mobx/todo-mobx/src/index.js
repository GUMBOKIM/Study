import ReactDOM from "react-dom";
import React from 'react';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {Provider} from "mobx-react";
import todoStore from "./stores/TodoStore";

ReactDOM.render(
  <Provider todoStore = {todoStore}>
    <App />
  </Provider>,
  document.getElementById('root')
);

reportWebVitals();
