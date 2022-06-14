import {observer} from "mobx-react";
import React, {useEffect, useState} from "react";
import {useMutation, useQuery} from "react-query";
import {ExamStore} from "../store/ExamStore";
import {ExamRepository} from "../repository/ExamRepository";
import {ITodo} from "../repository/ExamData";
import {queryClient} from "../App";

const Exam2Page_Store_Input: React.FC = () => {
    const [input, setInput] = useState('');
    return <div>
        <input type="text" onChange={(e) => setInput(e.target.value)} value={input}/>
        <button onClick={() => {
            ExamStore.addTodo(input);
            setInput('')
        }}>추가
        </button>
    </div>;
}

const Exam2Page_Store_Todo: React.FC<{ todo: ITodo }> = ({todo}) => {
    const [input, setInput] = useState(todo.content);
    return (
        <div>
            <input type="text" onChange={(e) => setInput(e.target.value)} value={input}/>
            <button onClick={() => ExamStore.updateTodo(todo.id, input)}>수정</button>
            <button onClick={() => ExamStore.deleteTodo(todo.id)}>삭제</button>
        </div>
    )
}

export const Exam2Page_Store: React.FC = observer(() => {
    useEffect(() => {
        ExamStore.getTodoList();
    }, [])

    return <>
        <Exam2Page_Store_Input/>
        <hr/>
        {ExamStore.todoList.map(todo => <Exam2Page_Store_Todo key={todo.id} todo={todo}/>)}
    </>
})

const Exam2Page_Query_Todo: React.FC<{ todo: ITodo }> = ({todo}) => {
    const [input, setInput] = useState(todo.content);
    const deleteTodo = useMutation(() => ExamRepository.deleteTodo(todo.id),
        {
            onSuccess: () => queryClient.invalidateQueries('todoList')
        });

    const modifyTodo = useMutation((content: string) => ExamRepository.updateTodo(todo.id, content),
        {
            onSuccess: () => queryClient.invalidateQueries('todoList')
        });

    return (
        <div>
            <input type="text" onChange={(e) => setInput(e.target.value)} value={input}/>
            <button onClick={() => modifyTodo.mutate(input)}>수정</button>
            <button onClick={() => deleteTodo.mutate()}>삭제</button>
        </div>
    )
}


const Exam2Page_Query_Input: React.FC = () => {
    const [input, setInput] = useState('');
    const addTodo = useMutation((content: string) => ExamRepository.addTodo(content),
        {
            onSuccess: () => {
                queryClient.invalidateQueries('todoList')
                setInput('');
            }

        });

    return <div>
        <input type="text" onChange={(e) => setInput(e.target.value)} value={input}/>
        <button onClick={() => {addTodo.mutate(input)}}>추가
        </button>
    </div>;
}

export const Exam2Page_Query: React.FC = observer(() => {
    const {isLoading, data} = useQuery('todoList', ExamRepository.getTodoList)
    if (isLoading) {
        return <div>로딩 중</div>
    }

    return <>
        <Exam2Page_Query_Input/>
        <hr/>
        {data!.map(todo => <Exam2Page_Query_Todo key={todo.id} todo={todo}/>)}
    </>
})
