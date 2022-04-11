import styled from 'styled-components';
import MenuStore from "./MenuStore";
import {useObserver} from "mobx-react";

const TeamMateDiv = styled.div`
  width: 200px;
  height: 100px;
  background-color: seagreen;
  margin: 10px;
  line-height: 50px;
  text-align: center;
`

const TeamMate = ({name}) => {
    return useObserver( () =>
        <TeamMateDiv>
            이름 : {name}
            <br/>
            점심 : {MenuStore.launchMenu}
        </TeamMateDiv>
    )
}

export default TeamMate;