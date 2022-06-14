import {makeAutoObservable} from "mobx";
import {IChat, IPost, ITodo} from "../repository/ExamData";
import {ExamRepository} from "../repository/ExamRepository";

export interface ChatProps {
    id: number;
    content: string;
    userName: string;
}

class ExamStoreClass {
    constructor() {
        makeAutoObservable(this);
    }

    // 예제 1
    post: IPost = {id: 0, title: '', content: ''};

    async getPost() {
        await ExamRepository.getPost().then(r => this.post = r);
    }

    initPost() {
        this.post = {id: 0, title: '', content: ''};
    }

    // 예제 2
    todoList: ITodo[] = [];

    initTodoList() {
        this.todoList = [];
    }

    async getTodoList() {
        this.todoList = await ExamRepository.getTodoList();
    }

    async addTodo(content: string) {
        await ExamRepository.addTodo(content);
        this.getTodoList();
    }

    async updateTodo(id: number, content: string) {
        await ExamRepository.updateTodo(id, content);
        this.getTodoList();
    }

    deleteTodo(id: number) {
        ExamRepository.deleteTodo(id);
        this.getTodoList();
    }

    // 예제 3
    chatList: ChatProps[] = [];

    initChatList() {
        this.chatList = [];
    }

    async getChatList() {
        const chatInfo: IChat[] = await ExamRepository.getChatList();
        const tempChatList: ChatProps[] = [];
        for (let chat of chatInfo) {
            tempChatList.push({
                content: chat.content, id: chat.id, userName: await this.getUserName(chat.userId)
            })
        }
        this.chatList = tempChatList;
    }

    async getUserName(userId: number) {
        const userInfo = await ExamRepository.getUserInfo(userId);
        return userInfo.name
    }
}

export const ExamStore = new ExamStoreClass();