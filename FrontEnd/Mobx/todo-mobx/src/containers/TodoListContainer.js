import React, { Component } from 'react';
import TodoView from '../views/TodoListView';
import {inject, observer} from "mobx-react";

@inject('todoStore')
@observer
class TodoListContainer extends Component {
  render(){

    console.log("list-render")
    return (
        <ul>

        </ul>

    )
  }
}

export default TodoListContainer;