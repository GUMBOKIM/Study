import styled, { keyframes } from "styled-components";

const Wrapper = styled.div`
  display: flex;
`;

const rotateAnimation = keyframes`
  0% {
    transform: rotate(0deg);
    border-radius: 0px;
  } 
  50% {
    transform:rotate(180deg);
    border-radius: 50px;
  }
  100%{
    transform: rotate(360deg);
    border-radius: 0px;
  } 
`;

const Box = styled.div`
  height: 200px;
  width: 200px;
  background-color: tomato;
  display: flex;
  justify-content: center;
  align-items: center;
  animation: ${rotateAnimation} 3s linear infinite;
  span {
    font-size: 90px;
    &:hover {
      font-size: 48px;
    }
    &:active {
      opacity: 0;
    }
  }
`;

function App() {
  return (
    <Wrapper>
      <Box>
        <span>asdff</span>
        </Box>
    </Wrapper>
  );
}

export default App;