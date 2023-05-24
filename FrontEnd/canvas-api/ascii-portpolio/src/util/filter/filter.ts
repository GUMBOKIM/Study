import {FilterFunction} from "./filter.type";

export const applyImageFilter = (image: ImageData, filter?: FilterFunction) => {
    const {width, height} = image;
    if (filter) filter(image);
}