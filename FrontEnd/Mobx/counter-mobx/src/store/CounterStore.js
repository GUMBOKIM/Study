import {observable, action, makeObservable, makeAutoObservable} from 'mobx'

class CounterStore {

    constructor() {
        makeAutoObservable(this);
    }

    @observable // 데코레이터
    _count = 5

    get count() {
        return this._count;
    }

    @action
    increment() {
        this._count ++;
        console.log(this._count)
    }

    @action
    decrement() {
        this._count --;
        console.log(this._count)
    }

}

export default new CounterStore();