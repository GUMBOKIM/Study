import React from "react";
import styled from "styled-components";

interface CardProps {
    left: number;
    top: number;
}

const Card: React.FC<CardProps> = ({left, top}) => {
    return <CardContainer style={{
        left: (left + "px"),
        top: (top + "px")
    }}/>;
}

const CardContainer = styled.div`
  position: absolute;

  width: 200px;
  height: 300px;

  background-color: red;

  transform: translate(-50%, -50%);
`;


export default Card;