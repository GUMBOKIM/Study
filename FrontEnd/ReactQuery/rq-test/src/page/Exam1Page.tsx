import {observer} from "mobx-react";
import React, {useEffect} from "react";
import {useQuery} from "react-query";
import {ExamStore} from "../store/ExamStore";
import {ExamRepository} from "../repository/ExamRepository";

export const Exam1Page_Store: React.FC = observer(() => {
    useEffect(() => {
        // ExamStore.initPost()
        ExamStore.getPost().then();
    }, [])

    const post = ExamStore.post;

    return <>
        <div>글번호 : {post.id}</div>
        <div>제목 : {post.title}</div>
        <div>내용 : {post.content}</div>
    </>
})

export const Exam1Page_Query: React.FC = observer(() => {
    const {data, isLoading} = useQuery('post', ExamRepository.getPost );

    if(isLoading) {
        return <div>로딩 중</div>
    }

    return <>
        <div>글번호 : {data!.id}</div>
        <div>제목 : {data!.title}</div>
        <div>내용 : {data!.content}</div>
    </>
})
