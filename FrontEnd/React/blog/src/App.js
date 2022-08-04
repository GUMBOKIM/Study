/* eslint-disable */
// ESLINT 사용 X

import React from "react";
import './App.css';

function App() {
    return (
        <div>
            안녕하세요
        </div>
    )
}

// Component
function Modal() {
    return (
        <>
            <div className="modal">
                <h2>제목</h2>
                <p>날짜</p>
                <p>내용</p>
            </div>
            <div className="modal">
                <h2>제목</h2>
                <p>날짜</p>
                <p>내용</p>
            </div>
            <div className="modal">
                <h2>제목</h2>
                <p>날짜</p>
                <p>내용</p>
            </div>
        </>
    )
        ;
}

export default App;
