import {observable} from "mobx";

const MenuStore = observable({
    launchMenu : `미정`,
    setLaunchMenuDaeHee() {
        this.launchMenu = '국밥';
    },
    setLaunchMenu(menu){
        this.launchMenu = menu;
    }
})

export default MenuStore;
