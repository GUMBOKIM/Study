import React, {useEffect} from 'react';
import {BrowserRouter, Navigate, Route, Routes, useNavigate} from "react-router-dom";
import MainPage from "./page/MainPage";
import {Exam1Page_Query, Exam1Page_Store} from "./page/Exam1Page";
import {Exam2Page_Query, Exam2Page_Store} from "./page/Exam2Page";
import {Exam3Page_Query, Exam3Page_Store} from "./page/Exam3Page";
import {PageHeader} from "./component/LayOut";
import {QueryClient, QueryClientProvider} from 'react-query';
import {Exam4Page_Normal, Exam4Page_Query} from "./page/Exam4Page";

const ResetInfo: React.FC = () => {
    const navigate = useNavigate();
    useEffect(() => {
    }, [navigate])
    return null;
}

export const queryClient = new QueryClient();


const App: React.FC = () => {
    return (
        <QueryClientProvider client={queryClient}>
            <BrowserRouter>
                <ResetInfo/>
                <PageHeader/>
                <Routes>
                    <Route path='main' element={<MainPage/>}/>
                    <Route path='exam1s/:postId' element={<Exam1Page_Store/>}/>
                    <Route path='exam1q/:postId' element={<Exam1Page_Query/>}/>
                    <Route path='exam2s' element={<Exam2Page_Store/>}/>
                    <Route path='exam2q' element={<Exam2Page_Query/>}/>
                    <Route path='exam3s' element={<Exam3Page_Store/>}/>
                    <Route path='exam3q' element={<Exam3Page_Query/>}/>
                    <Route path='exam4s' element={<Exam4Page_Normal/>}/>
                    <Route path='exam4q' element={<Exam4Page_Query/>}/>
                    <Route path='*' element={<Navigate replace to={'main'}/>}/>
                </Routes>
            </BrowserRouter>
        </QueryClientProvider>


    );
}

export default App;
