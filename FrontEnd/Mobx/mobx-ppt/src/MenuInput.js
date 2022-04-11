import styled from 'styled-components';
import MenuStore from "./MenuStore";

const MenuInputTitle = styled.div`
  text-align: center;
  width: 200px;
  margin: 1px 10px;
`

const MenuInputButton = styled.div`
  border: 1px solid black;
  background-color: red;
  width: 200px;
  text-align: center;
  margin: 1px 10px;
`

const MenuInputArea = styled.input`
  width: 200px;
  margin: 1px 10px;
`

const MenuInput = () => {
    const onChange = e => MenuStore.setLaunchMenu(e.target.value);
    const onClick = () => MenuStore.setLaunchMenuDaeHee();
    return  (
        <div>
            <MenuInputTitle>메뉴를 입력해주세용</MenuInputTitle>
            <MenuInputButton onClick={onClick}>국밥 버튼</MenuInputButton>
            <MenuInputArea onChange={onChange}/>
        </div>
    )
}

export default MenuInput;