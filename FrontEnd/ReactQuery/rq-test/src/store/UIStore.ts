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

    // 예제 4
    parallelQuery1Success = false;
    parallelQuery2Success = false;
    parallelQuery3Success = false;

    initParallel() {
        this.parallelQuery1Success = false;
        this.parallelQuery2Success = false;
        this.parallelQuery3Success = false;
    }
}

export const UIStore = new UIStoreClass();