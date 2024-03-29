import React from "react";
import {Link} from "react-router-dom";
import {PostData} from "../repository/ExamData";
import {createRandomNumber} from "../util/util";

const MainPage: React.FC = () => {
    const randomPostId = () => {
        return createRandomNumber(PostData.length) + 1;
    }


    return (
        <>
            <h3>장점 1 - 비동기 과정 관리</h3>
            <p>
                isLoading, isError등 선언적으로 관리할 수 있음
                <br/>
                (+ store의 state를 신경쓰지 않아도 됨)
            </p>
            <span>
                <Link to={`/exam1S/${randomPostId()}`}>Store</Link>
                {` `}
                <Link to={`/exam1Q/${randomPostId()}`}>Query</Link>
            </span>
            <hr/>
            <h3>장점 2 - Mutation</h3>
            <p>
                Mutation을 통해 API 호출 후 결과에 따라 작업을 지정해 줄 수 있음.
                <br/>
                서버 상태 업데이트(CUD) 성공 시, 기존 쿼리 무효화(최신 데이터를 다시 서버로 부터 요청)
            </p>
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
            <hr/>
            <h3>장점 4 - useQueries</h3>
            <p>useQueries를 통해서 간편한 병렬처리 가능</p>
            <span>
                    <Link to='/exam4S'>미적용</Link>
                {` `}
                <Link to='/exam4Q'>적용</Link>
            </span>
        </>
    )
}

export default MainPage;