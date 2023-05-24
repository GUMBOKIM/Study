import {applyColor, convertXYToIndex} from "./util";
import {FilterFunction, RGBA} from "./filter.type";

type NoiseFilterOption = {
    percent?: number;
    noiseColor?: RGBA;
}

type NoiseFilterType = (options?: NoiseFilterOption) => FilterFunction;

const NoiseFilter: NoiseFilterType = (options) => {

    const defaultNoiseColor: RGBA = {
        r: 0,
        g: 0,
        b: 0,
        a: 1,
    }

    return (imageData) => {
        const percent = options?.percent ?? 50;
        const noiseColor = options?.noiseColor ?? defaultNoiseColor;

        const {width: x_max, height: y_max, data} = imageData;

        for (let y = 0; y < y_max; y++) {
            for (let x = 0; x < x_max; x++) {
                const index = convertXYToIndex({x, y}, x_max);
                if (Math.random() * 100 <= percent) {
                    if (noiseColor) {
                        applyColor(data, index, noiseColor);
                    } else {
                        applyColor(data, index, defaultNoiseColor);
                    }
                }
            }
        }
    }
}

export default NoiseFilter;