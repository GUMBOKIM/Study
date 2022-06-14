import {makeAutoObservable} from "mobx";

class UIStoreClass {
    constructor() {
        makeAutoObservable(this);
    }

    // 예제 3
    chatApiCallCnt = 0;
    userApiCallCnt = 0;

    callChatApi() {
        this.chatApiCallCnt ++;
    }

    callUserApi() {
        this.userApiCallCnt ++;
    }

    initApiCnt(){
        this.chatApiCallCnt = 0;
        this.userApiCallCnt = 0;
    }
}

export const UIStore = new UIStoreClass();