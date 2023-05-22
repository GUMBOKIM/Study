import React, {useLayoutEffect, useRef} from "react";
import styled from "styled-components";
// @ts-ignore
import backgroundImage from "../asset/img/Background.png";
import Card from "./Card";

const TestArray = Array.from({length: 10}, (_, index) => index + 1);

const Background = () => {
    const backgroundContainerRef = useRef<HTMLDivElement>(null);
    const objectContainerRef = useRef<HTMLDivElement>(null);

    useLayoutEffect(() => {
        const backgroundContainer = backgroundContainerRef.current;
        const objectContainer = objectContainerRef.current;
        if (backgroundContainer && objectContainer) {
            let distance = 0;
            const keyPressEvent = (e: KeyboardEvent) => {
                const key = e.key;
                if (key === "a") {
                    distance += 10;
                } else if (key === "s") {
                    distance -= 10;
                }
                backgroundContainer.style.backgroundPositionX = distance + "px";
                objectContainer.style.left = distance + "px";
            }
            window.addEventListener('keypress', keyPressEvent);
        }
    }, [backgroundContainerRef, objectContainerRef]);

    return (
        <>
            <BackgroundContainer ref={backgroundContainerRef}>
                <ObjectContainer ref={objectContainerRef}>
                    {TestArray.map(value => <Card key={value}
                                                  left={(value - 1) * 600 + (Math.random() * 50)}
                                                  top={300 + (Math.random() * 300)}/>)}
                </ObjectContainer>
            </BackgroundContainer>
        </>
    );
}

const BackgroundContainer = styled.div`
  position: relative;
  overflow-x: hidden;
  width: 100vw;
  height: 100vh;
  background-image: url(${backgroundImage});
`;

const ObjectContainer = styled.div`
  position: absolute;
`;

export default Background;