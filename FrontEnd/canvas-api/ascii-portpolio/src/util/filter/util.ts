import {RGBA} from "./filter.type";

export const convertIndexToXY = (index: number, width: number) => {
    return {x: 0, y: 0}
}

export const convertXYToIndex = (XY: { x: number, y: number }, width: number) => {
    const {x, y} = XY;
    return (x + y * width) * 4;
}

export const getRGBA = (data: Uint8ClampedArray, index: number): RGBA => {
    return {r: data[index], g: data[index + 1], b: data[index + 2], a: data[index + 3]}
}

export const applyColor = (data: Uint8ClampedArray, index: number, color: RGBA) => {
    data[index] = color.r;
    data[index + 1] = color.g;
    data[index + 2] = color.b;
    data[index + 3] = color.a;
}