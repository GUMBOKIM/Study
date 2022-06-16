import {observer} from "mobx-react";
import React, {useEffect, useState} from "react";
import {UIStore} from "../store/UIStore";
import {ExamRepository} from "../repository/ExamRepository";
import {useQueries} from "react-query";

const ParallelQueryStatus: React.FC = observer(() => {
    return (
        <div>
            <div>Query1 : {UIStore.parallelQuery1Success ? '완료' : '요청 중'} </div>
            <div>Query2 : {UIStore.parallelQuery2Success ? '완료' : '요청 중'} </div>
            <div>Query3 : {UIStore.parallelQuery3Success ? '완료' : '요청 중'} </div>
        </div>
    )
});

export const Exam4Page_Normal: React.FC = observer(() => {
    const [query1Success, setQuery1Success] = useState(false);
    const [query2Success, setQuery2Success] = useState(false);
    const [query3Success, setQuery3Success] = useState(false);

    useEffect(() => {
        UIStore.initParallel();
        ExamRepository.testQuery1().then(() => setQuery1Success(true));
        ExamRepository.testQuery2().then(() => setQuery2Success(true));
        ExamRepository.testQuery3().then(() => setQuery3Success(true));
    }, []);

    return (
        <div>
            <ParallelQueryStatus/>
            {
                (query1Success && query2Success && query3Success) ?
                    <div>성공</div> : <div>준비중</div>
            }
        </div>
    )
})

export const Exam4Page_Query: React.FC = observer(() => {
    useEffect(() => {
        UIStore.initParallel();
    }, [])

    const queries = useQueries([
        {
            queryKey: ['query', 1],
            queryFn: () => ExamRepository.testQuery1(),
            refetchOnMount: "always"
        },
        {
            queryKey: ['query', 2],
            queryFn: () => ExamRepository.testQuery2(),
            refetchOnMount: "always"
        },
        {
            queryKey: ['query', 3],
            queryFn: () => ExamRepository.testQuery3(),
            refetchOnMount: "always"
        }
    ])

    return (
        <div>
            <ParallelQueryStatus/>
            {
                queries.find(query => query.isSuccess === false) ?
                    <div>준비중</div> : <div>성공</div>
            }
        </div>
    )
})
