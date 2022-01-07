/* eslint-disable */
// ESLINT 사용 X

import React, {useState} from "react";
import logo from './logo.svg';
import './App.css';

function App() {

    // let post = '김대희12341234';
    //
    // function createPost() {
    //     return "post"
    // }
    // // 0. class는 이미 자바스크립트에 존재하기 때문에 className으로 사용
    // // 1. { value } 형태로 사용
    // // 2. 스타일은 object 형태로 넣는다
    // //    바(-)는 자바스크립트에서 입력이 되지 않기 때문에 camelCase를 사용한다
    // // 3. src={경로}
    // return (
    //     <div className="App">
    //         <div className="black-nav">
    //             <div style={ {color : 'blue', fontSize : "30 px"}}>개발 Blog</div>
    //         </div>
    //         <h4>{post}</h4>
    //         <h4>{createPost()}</h4>
    //         <img src={logo}/>
    //     </div>
    // );

    // // 1. useState => [state 데이터, state 데이터 변경 함수]
    // // state를 사용하는 이유는 변경되면 HTML이 자동으로 재렌더링이 된다.
    // // 자주 바뀌거나, 중요한 데이터는 변수 말고 state로 저장해서 쓰면된다.
    // let [글제목, 글제목변경] = useState(['남자 코트 추천1', '남자 바지 추천1']);
    //
    // return (
    //     <div className="App">
    //         <div className="black-nav">
    //             <div>개발 Blog</div>
    //         </div>
    //         <div className="list">
    //             <h3>{ 글제목[1] }</h3>
    //             <p>2월 17일 발행</p>
    //             <hr/>
    //         </div>
    //     </div>
    // );

    // // state 변경 시, state 변경함수 사용해서 변경
    // // 주의 ! 0. 기존의 state를 바로 수정해서 사용하면 X -> 얕은복사 X 깊은복사 O
    // //       1. 기존 자료 형태랑 똑같아야함
    // let [글제목, 글제목_변경] = useState(['남자 코트 추천', '남자 바지 추천']);
    // let [좋아요, 좋아요_변경]= useState(0);
    // return (
    //     <div className="App">
    //         <div className="black-nav">
    //             <div>개발 Blog</div>
    //         </div>
    //         <div className="list">
    //             <h3>{글제목} <span onClick={() => { 좋아요_변경(좋아요+1)}}>👍</span>{좋아요}</h3>
    //             <p>2월 17일 발행</p>
    //             <hr/>
    //         </div>
    //         <div className="list">
    //             <h3></h3>
    //             <p>2월 17일 발행</p>
    //             <hr/>
    //         </div>
    //         <div className="list">
    //             <h3></h3>
    //             <p>2월 17일 발행</p>
    //             <hr/>
    //         </div>
    //     </div>
    // );

    // Component 유의사항
    // 1. 이름은 대괄호
    // 2. return() 안에 있는건 태그 하나로 묶어야함
    // 3.
    let [글제목, 글제목_변경] = useState(['남자 코트 추천', '남자 바지 추천']);
    let [좋아요, 좋아요_변경] = useState(0);
    return (
        <div className="App">
            <div className="black-nav">
                <div>개발 Blog</div>
            </div>
            <div className="list">
                <h3>{글제목} <span onClick={() => {
                    좋아요_변경(좋아요 + 1)
                }}>👍</span>{좋아요}</h3>
                <p>2월 17일 발행</p>
                <hr/>
            </div>
            <div className="list">
                <h3>2</h3>
                <p>2월 17일 발행</p>
                <hr/>
            </div>
            <div className="list">
                <h3>3</h3>
                <p>2월 17일 발행</p>
                <hr/>
            </div>

            <Modal/>

        </div>
    );
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
