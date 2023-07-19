import { createStore, applyMiddleware, compose } from "redux";
import rootReducer from "./reducers";
import ThunkMiddleware from "redux-thunk";
import createSagaMiddleware from "redux-saga";
import rootSaga from "./sagas";

// import asyncFunctionMiddleware from "./middlewares/asyncFucntionMiddleware";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  rootReducer,
  composeEnhancers(applyMiddleware(ThunkMiddleware, sagaMiddleware))
);

sagaMiddleware.run(rootSaga);

export default store;
