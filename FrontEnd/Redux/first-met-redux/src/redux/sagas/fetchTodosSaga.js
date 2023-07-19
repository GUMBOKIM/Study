import {
  fetchTodosFailed,
  fetchTodosRequested,
  fetchTodosSucceeded,
} from "../actions/fetchTodosAction";
import { put, delay, takeEvery } from "redux-saga/effects";

function* fetchTodos() {
  try {
    const data = yield delay(3000, ["data 1", "data 2", "data 3"]);

    yield put(fetchTodosSucceeded(data));
  } catch (error) {
    yield put(fetchTodosFailed(error));
  }
}

function* fetchTodosSaga() {
  yield takeEvery(fetchTodosRequested, fetchTodos);
}

export default fetchTodosSaga;
