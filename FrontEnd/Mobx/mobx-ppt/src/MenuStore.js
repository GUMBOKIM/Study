import {observable} from "mobx";
import {createContext, useState} from "react";

// const MenuStore = observable({
//     launchMenu : `미정`,
//     setLaunchMenuDaeHee() {
//         this.launchMenu = '국밥';
//     },
//     setLaunchMenu(menu){
//         this.launchMenu = menu;
//     }
// })

export const MyContext = createContext({
    launchMenu: '미정'
})

const MenuStore = (props) => {
    const [launchMenu, setName] = useState('미정');
}

export default MenuStore;
