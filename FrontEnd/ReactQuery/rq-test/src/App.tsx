import React, {useEffect} from 'react';
import {BrowserRouter, Route, Routes, useNavigate} from "react-router-dom";
import MainPage from "./page/MainPage";
import {Exam1Page_Query, Exam1Page_Store} from "./page/Exam1Page";
import {Exam2Page_Query, Exam2Page_Store} from "./page/Exam2Page";
import {Exam3Page_Query, Exam3Page_Store} from "./page/Exam3Page";
import {PageHeader} from "./component/LayOut";
import {QueryClient, QueryClientProvider} from 'react-query';

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
                    <Route path='exam1s' element={<Exam1Page_Store/>}/>
                    <Route path='exam1q' element={<Exam1Page_Query/>}/>
                    <Route path='exam2s' element={<Exam2Page_Store/>}/>
                    <Route path='exam2q' element={<Exam2Page_Query/>}/>
                    <Route path='exam3s' element={<Exam3Page_Store/>}/>
                    <Route path='exam3q' element={<Exam3Page_Query/>}/>
                </Routes>
            </BrowserRouter>
        </QueryClientProvider>


    );
}

export default App;
