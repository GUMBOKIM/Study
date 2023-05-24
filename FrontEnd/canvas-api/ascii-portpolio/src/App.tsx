import React from 'react';
import VideoCard from "./component/VideoCard";
import VideoCard1 from "./component/VideoCard1";

function App() {
    return (
        <>
            <VideoCard/>
            <span>Dithering</span>
            <VideoCard1/>
            <span>Noise</span>
        </>
    );
}

export default App;
