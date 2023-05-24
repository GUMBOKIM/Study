import {FilterFunction} from "./filter.type";

type DitheringFilterOption = {
    threshold?: number;
}

type DitheringFilterType = (option?: DitheringFilterOption) => FilterFunction;
const DitheringFilter: DitheringFilterType = (option) => {

    return (image) => {
        const {data} = image;
        const threshold = option?.threshold ?? 124;
        for (let index = 0; index < data.length; index += 4) {
            const r = data[index];
            const g = data[index + 1];
            const b = data[index + 2];
            data[index] = data[index + 1] = data[index + 2] = (r + g + b) / 3 > threshold ? 255 : 0;
        }
    }
}

export default DitheringFilter;