import React from "react";
import styled from "styled-components";
import {Outlet, Link} from "react-router-dom";

export const PageHeader: React.FC = () => {
    return <>
        <h3>
            <Link to={'main'}>Main</Link>
        </h3>
        <hr/>
        <Outlet/>
    </>
}

export const ContentContainer = styled.div`
  width: 100vw;
  display: flex;

  > div:nth-of-type(1) {
    width: 50%;
  }

  > div:nth-of-type(2) {
    width: 50%;
  }
`
