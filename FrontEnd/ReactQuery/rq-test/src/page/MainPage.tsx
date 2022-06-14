import React from "react";
import {Link} from "react-router-dom";

const MainPage: React.FC = () => {
    return (
        <>
            <h3>장점 1 - 비동기 과정 관리</h3>
            <p>
                isLoading, isError등 선언적으로 관리할 수 있음
                <br/>
                (+ store의 state를 신경쓰지 않아도 됨)
            </p>
            <span>
                <Link to='/exam1S'>Store</Link>
                {` `}
                <Link to='/exam1Q'>Query</Link>
            </span>
            <hr/>
            <h3>장점 2 - Mutation</h3>
            <p>Mutation을 통한 데이터 업데이트(CUD) 즉시 반영</p>
            <span>
                <Link to='/exam2S'>Store</Link>
                {` `}
                <Link to='/exam2Q'>Query</Link>
            </span>
            <hr/>
            <h3>장점 3 - 캐싱 기능</h3>
            <p>캐싱 기능을 통한 중복 요청 방지</p>
            <span>
                <Link to='/exam3S'>Store</Link>
                {` `}
                <Link to='/exam3Q'>Query</Link>
            </span>
        </>
    )
}

export default MainPage;