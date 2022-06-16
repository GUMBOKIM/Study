import {createRandomNumber} from "../util/util";

export interface IPost {
    id: number;
    title: string;
    content: string;
}

export interface IUser {
    id: number;
    name: string;
}

export interface IChat {
    id: number;
    content: string;
    userId: number;
}


export interface ITodo {
    id: number,
    content: string;
}

export const PostData: IPost[] = [];
export const UserData: IUser[] = [];
export const ChatData: IChat[] = [];
export const TodoList: ITodo[] = [];

const postDataLength = 10;
for (let i = 1; i <= postDataLength; i++) {
    PostData.push(
        {
            id: i,
            title: '게시글 ' + i,
            content: '내용 ' + i
        }
    )
}

const userDataLength = 5;
for (let i = 1; i <= userDataLength; i++) {
    UserData.push({
        id: i,
        name: "사용자 " + i
    })
}

const chatDataLength = 100;
for (let i = 1; i <= chatDataLength; i++) {
    const randomUserId = createRandomNumber(userDataLength) + 1
    ChatData.push({
        id: i,
        userId: randomUserId,
        content: "채팅 " + i
    })
}

const todoDataLength = 10;
for (let i = 1; i <= todoDataLength; i++) {
    TodoList.push({
        id: i,
        content: "할일 " + i
    })
}