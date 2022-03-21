import {useEffect, useState} from "react";

// function App() {
//     const [counter, setCounter] = useState(0);
//     const [keyword, setKeyword] = useState("");
//     const onClick = () => setCounter((prev) => prev + 1);
//     const onChange = (event) => setKeyword(event.target.value);
//     console.log("i run all the time");
//     useEffect(() => {
//         console.log("i run only once.");
//     }, []);
//     useEffect(() => {
//         if (keyword !== "" && keyword.length > 5)
//             console.log("search For", keyword);
//     }, [keyword]);
//
//     useEffect(() => {
//             console.log("keyboard & counter");
//     }, [keyword, counter]);
//
//     return (
//         <div>
//             <input value={keyword}
//                    onChange={onChange}
//                    type="text"
//                    placeholder="Search here..."/>
//             <h1>{counter}</h1>
//             <button onClick={onClick}>Click me</button>
//         </div>
//     )
// }

function Hello() {
    function effectFn() {
        console.log("created");
        return destroyedFn;
    }

    function destroyedFn() {
        console.log("destroy");
    }

    useEffect(effectFn, []);
    return <h1>Hello</h1>;
}


function App() {
    const [showing, setShowing] = useState(false);
    const onClick = () => setShowing((prev) => !prev);
    return (
        <div>
            {showing ? <Hello/> : null}
            <button onClick={onClick}>{showing ? "Hide" : "Show"}</button>
        </div>
    )
}

export default App;
