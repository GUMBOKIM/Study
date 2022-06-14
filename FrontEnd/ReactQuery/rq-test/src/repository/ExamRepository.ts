import {ChatData, IChat, IPost, ITodo, IUser, PostData, TodoList, UserData} from "./ExamData";
import {UIStore} from "../store/UIStore";

class Repo {
    // 에제 1
    async getPost(): Promise<IPost> {
        const postId = Math.floor(PostData.length * Math.random() + 1);
        return new Promise((resolve) => {
            setTimeout(() => {
                resolve(PostData.find(post => post.id === postId)!);
            }, 300)
        });
    }

    // 예제 2
    getTodoList(): Promise<ITodo[]> {
        return new Promise((resolve) => setTimeout(() => {resolve(TodoList);}, 20)
        )
    }

    addTodo(content: string): Promise<ITodo> {
        const lastId = TodoList.length === 0 ? 0 : TodoList[TodoList.length - 1].id;
        TodoList.push({
            id: lastId + 1,
            content: content
        })
        console.log(TodoList);
        return new Promise((resolve) => setTimeout(() => resolve({id: lastId + 1, content}), 20));
    }

    deleteTodo(id: number): Promise<void> {
        for (let i = 0; i < TodoList.length; i++) {
            if (TodoList[i].id === id) {
                TodoList.splice(i, 1);
                break;
            }
        }
        return new Promise((resolve) => setTimeout(() => resolve(), 10))
    }

    updateTodo(id: number, content: string): Promise<ITodo> {
        for (let i = 0; i < TodoList.length; i++) {
            if (TodoList[i].id === id) {
                TodoList[i].content = content;
                break;
            }
        }
        return new Promise((resolve) => setTimeout(() => resolve({id, content}), 10));
    }

// 예제 3
    getChatList()
        :
        Promise<IChat[]> {
        console.log(`Chat API 호출`);
        UIStore.callChatApi();
        return new Promise((resolve) =>
            setTimeout(() => {
                resolve(ChatData);
            }, 10)
        )
    }

    getUserInfo(userId
                    :
                    number
    ):
        Promise<IUser> {
        console.log(`User API 호출 - ${userId}`)
        UIStore.callUserApi();
        const userInfo = UserData.find(user => user.id === userId);
        return new Promise((resolve) => {
            setTimeout(() => {
                resolve(userInfo ? userInfo : {id: 0, name: '익명'});
            }, 20)
        });
    }

}

export const ExamRepository = new Repo();
