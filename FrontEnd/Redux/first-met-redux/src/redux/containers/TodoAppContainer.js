import { connect } from "react-redux";
import TodoApp from "../../components/TodoApp";
// import {
//   addTodoActionCreator,
//   removeTodoActionCreator,
//   removeAllActionCreator,
// } from "../ducks/todoDuck";
// import {
//   addTodoActionCreator,
//   removeAllActionCreator,
//   removeTodoActionCreator,
// } from "../actions";
import {
  addTodo as addTodoActionCreator,
  removeTodo as removeTodoActionCreator,
  removeAll as removeAllActionCreator,
} from "../actions/todoAction";
import addTodoThunkActionCreator from "../thunks/addTodoThunk";
import { fetchTodosRequested as fetchTodosRequestedActionCreator } from "../actions/fetchTodosAction";

function mapStateToProps(state, ownProps) {
  return {
    todoItems: [...state.todo, ...state.fetchTodos.data],
  };
}

function mapDispatchToProps(dispatch, ownProps) {
  return {
    addTodo: (text) => {
      // dispatch(addTodoActionCreator(text));
      dispatch(addTodoThunkActionCreator(text));
    },
    removeTodo: () => {
      dispatch(removeTodoActionCreator());
    },
    removeAll: () => {
      dispatch(removeAllActionCreator());
    },
    triggerAsyncFunction: (asyncFunction) => {
      dispatch(asyncFunction);
    },
    fetchTodo: () => {
      dispatch(fetchTodosRequestedActionCreator());
    },
  };
}

const TodoAppContainer = connect(mapStateToProps, mapDispatchToProps)(TodoApp);

export default TodoAppContainer;
