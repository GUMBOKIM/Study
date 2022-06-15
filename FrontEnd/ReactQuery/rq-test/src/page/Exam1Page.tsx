import {observer} from "mobx-react";
import React, {useEffect} from "react";
import {useQuery} from "react-query";
import {ExamStore} from "../store/ExamStore";
import {ExamRepository} from "../repository/ExamRepository";
import {useParams} from "react-router-dom";

export const Exam1Page_Store: React.FC = observer(() => {
    const {postId} = useParams();

    useEffect(() => {
        // 초기화를 개발자가 직접 해주어야한다.
        // ExamStore.initPost()
        ExamStore.getPost(Number(postId)).then();
    }, [])

    const post = ExamStore.post;

    return <>
        <div>글번호 : {post.id}</div>
        <div>제목 : {post.title}</div>
        <div>내용 : {post.content}</div>
    </>
})

export const Exam1Page_Query: React.FC = () => {
    const {postId} = useParams();
    const {data, isLoading} = useQuery(['post', Number(postId)], () => ExamRepository.getPost(Number(postId)), {
        cacheTime: 0,
    });

    return <>
        {isLoading ?
            <div>준비중</div>
            :
            <>
                <div>글번호 : {data!.id}</div>
                <div>제목 : {data!.title}</div>
                <div>내용 : {data!.content}</div>
            </>
        }
    </>
}
