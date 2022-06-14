import {observer} from "mobx-react";
import React, {useEffect} from "react";
import {useQuery} from "react-query";
import {ExamStore} from "../store/ExamStore";
import {UIStore} from "../store/UIStore";
import {ExamRepository} from "../repository/ExamRepository";
import {userInfo} from "os";
import {IChat} from "../repository/ExamData";

export const Exam3Page_Store: React.FC = observer(() => {
    useEffect(() => {
        UIStore.initApiCnt();
        ExamStore.initChatList();
        ExamStore.getChatList().then();
    }, [])

    return <>
        <div>Exam3</div>
        <div>ChatList Api Call - {UIStore.chatApiCallCnt}</div>
        <div>UserInfo Api Call - {UIStore.userApiCallCnt}</div>
        {ExamStore.chatList.map((chat) => {
            return <div key={chat.id}>{chat.userName} - {chat.content}</div>
        })}
    </>
})

const Exam3Page_Query_Child: React.FC<{ chat: IChat }> = ({chat}) => {
    const {data, isLoading} = useQuery(['userInfo', chat.userId], () => ExamRepository.getUserInfo(chat.userId),);
    if(isLoading) {
        return null;
    }
    return  <div key={chat.id}>{data!.name} - {chat.content}</div>
}


export const Exam3Page_Query: React.FC = observer(() => {
    useEffect(() => {
        UIStore.initApiCnt();
    }, [])

    const {data, isLoading} = useQuery('chatList', ExamRepository.getChatList ,{
        staleTime: 0,
        cacheTime: 0
    });

    return (
        <>
            <div>Exam3</div>
            <div>ChatList Api Call - {UIStore.chatApiCallCnt}</div>
            <div>UserInfo Api Call - {UIStore.userApiCallCnt}</div>
            {data && data.map(chat => <Exam3Page_Query_Child key={chat.id} chat={chat}/>)}
        </>
    )
})
