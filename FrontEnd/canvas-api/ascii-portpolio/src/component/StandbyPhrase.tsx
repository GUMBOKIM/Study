import styled, {css} from "styled-components";
import {useLayoutEffect, useState} from "react";

const StandbyPhrase = () => {
    const [active, setActive] = useState<boolean>(true);

    useLayoutEffect(() => {
        let count = 1;

        const secondInterval = setInterval(() => {
            if (count === 1) {
                setActive(true);
            } else if (count > 0) count--;
        }, 1000);

        const keyPressEvent = () => {
            setActive(false);
            count = 3;
        };

        document.body.addEventListener('keypress', keyPressEvent);
        return () => {
            document.body.removeEventListener('keypress', keyPressEvent);
            clearInterval(secondInterval);
        }
    }, [setActive])

    return (
        <PhraseContainer active={active}>
            <Phrase>
                <span>Welcome to</span>
                <span>LOW-FI World</span>
            </Phrase>
        </PhraseContainer>
    );
}

const PhraseContainer = styled.div<{ active: boolean; }>`
  width: fit-content;

  position: fixed;
  top: 50vh;
  left: 50vw;
  transform: translate(-50%, -50%);

  transition: visibility 0.5s ease-out;

  ${({active}) =>
          (active ? css`
                            visibility: visible;
                            transform: scale(1) translate(-50%, -50%);
                          ` :
                          css`
                            transform: scale(0) translate(-50%, -50%);
                            visibility: hidden;
                          `
          )
  }
`;

const Phrase = styled.h1`
  display: flex;
  flex-direction: column;
  gap: 40px;
  align-items: center;
  justify-content: center;

  & > span {
    display: block;
  }

  & > span:first-of-type {
    font-size: 30px;
  }

  & > span:last-of-type {
    font-size: 40px;
  }

  animation: FontBiggerNSmaller 1s linear infinite;

  @keyframes FontBiggerNSmaller {
    0% {
      transform: scale(1);
    }
    25% {
      transform: scale(0.8);
    }
    50% {
      transform: scale(1);
    }
    75% {
      transform: scale(1.2);
    }
    100% {
      transfomr: scale(1);
    }
  }
`;

export default StandbyPhrase;