import {observable, action, makeObservable, computed, toJS} from 'mobx';

class TodoStore {

    constructor(props) {
        makeObservable(this);
    }

    @observable
    _todo = {}

    @observable
    _todos = [];

    @observable
    _searchText = '';

    get todos() {
        return toJS(this._todos);
    }

    get searchText() {
        return this._searchText;
    }

    get todo() {
        return this._todo;
    }

    @action
    addTodo(todo){
        this._todos.push(todo);
    }

    @action
    setTodoProps(name, value) {
        this._todo = {
            ...this._todo,
            [name] : value
        }
    }

    @action
    setSearchText(searchText){
        this._searchText = searchText;
    }
}

export default new TodoStore();