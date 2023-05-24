import {FilterFunction} from "./filter.type";

type LowQualityFilterOption = {
    quality?: number;
}

type LowQualityFilterType = (option?: LowQualityFilterOption) => FilterFunction;
const LowQualityFilter: LowQualityFilterType = (option) => {
    const quality = option?.quality ?? 100;

    return (image) => {
        const {data} = image;
        
    }
}

export default LowQualityFilter;