import {ChatData, IChat, IPost, ITodo, IUser, PostData, TodoList, UserData} from "./ExamData";
import {UIStore} from "../store/UIStore";
import {createRandomNumber, sleep} from "../util/util";

class Repo {
    // 에제 1
    async getPost(postId: number): Promise<IPost> {
        return sleep(PostData.find(post => post.id === postId)!, 300);
    }

    // 예제 2
    getTodoList(): Promise<ITodo[]> {
        return sleep(TodoList, 20);
    }

    addTodo(content: string): Promise<ITodo> {
        const lastId = TodoList.length === 0 ? 0 : TodoList[TodoList.length - 1].id;
        TodoList.push({
            id: lastId + 1,
            content: content
        })
        return sleep({id: lastId + 1, content}, 20);
    }

    deleteTodo(id: number): Promise<void> {
        for (let i = 0; i < TodoList.length; i++) {
            if (TodoList[i].id === id) {
                TodoList.splice(i, 1);
                break;
            }
        }
        return sleep(console.log('DELETE'), 10);
    }

    updateTodo(id: number, content: string): Promise<ITodo> {
        for (let i = 0; i < TodoList.length; i++) {
            if (TodoList[i].id === id) {
                TodoList[i].content = content;
                break;
            }
        }
        return sleep({id, content}, 10);
    }

// 예제 3
    getChatList(): Promise<IChat[]> {
        console.log(`Chat API 호출`);
        UIStore.callChatApi();
        return sleep(ChatData, 10);
    }

    getUserInfo(userId: number): Promise<IUser> {
        console.log(`User API 호출 - ${userId}`)
        UIStore.callUserApi();
        const userInfo = UserData.find(user => user.id === userId);
        return sleep(userInfo ? userInfo : {id: 0, name: '익명'}, 20);
    }

    // 에제4
    testQuery1(): Promise<boolean> {
        UIStore.parallelQuery1Success = true;
        return sleep(true, createRandomNumber(5) * 1000)
            .then(() => UIStore.parallelQuery1Success = true);
    }

    testQuery2(): Promise<boolean> {
        return sleep(true, createRandomNumber(5) * 1000)
            .then(() => UIStore.parallelQuery2Success = true);
    }

    testQuery3(): Promise<boolean> {
        return sleep(true, createRandomNumber(5) * 1000)
            .then(() => UIStore.parallelQuery3Success = true);
    }
}

export const ExamRepository = new Repo();
