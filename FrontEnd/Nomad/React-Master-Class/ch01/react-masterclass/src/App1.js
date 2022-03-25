import styled from "styled-components";

const Father = styled.div`
  display: flex;
`;

// const BoxOne = styled.div`
//   background-color: teal;
//   width: 100px;
//   height: 100px;
// `;

// const BoxTwo = styled.div`
//   background-color: tomato;
//   width: 100px;
//   height: 100px;
// `;

const Box = styled.div`
  background-color: ${(props) => props.bgColor};
  width: 100px;
  height: 100px;
`;

const Circle = styled(Box)`
  border-radius: 50px;
`;

const Btn = styled.button`
  color: white;
  background-color: tomato;
  border: 0;
  border-radius: 15px;
`;

const Link = styled(Btn)``;
function App() {
  return (
    <div>
      <Father>
        <Box bgColor="teal" />
        <Circle bgColor="tomato" />
        <Btn>login1</Btn>
        <Btn as="a">login2</Btn> {/* 태그 변경*/}
      </Father>
    </div>
  );
}

export default App;
