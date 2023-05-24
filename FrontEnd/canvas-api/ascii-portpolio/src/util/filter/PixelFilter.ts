import {applyColor, convertXYToIndex, getRGBA} from "./util";
import {FilterFunction} from "./filter.type";

const pixelSize = 2;

// 픽셀 사이즈 크기만큼 색상 값을 평균을 계산해, 해당 평균으로 바꿔주는 필터
const PixelFilter: FilterFunction = (imageData) => {
    const {width: x_max, height: y_max} = imageData;

    for (let y_start = 0; y_start < y_max; y_start + pixelSize) {
        for (let x_start = 0; x_start < x_max; x_start + pixelSize) {
            // const color: RGBA = {
            //     r: 0,
            //     g: 0,
            //     b: 0,
            //     a: 0,
            // }
            // let count = 0;
            //
            // // 평균 픽셀에 RGB 값 더하기
            // for (let dy = 0; dy < pixelSize; dy++) {
            //     for (let dx = 0; dx < pixelSize; dx++) {
            //         const nx = x_start + dx;
            //         const ny = y_start + dy;
            //         if (nx < x_max && ny < y_max) {
            //             const selectedPixel = getRGBA(imageData.data, convertXYToIndex({x: nx, y: ny}, x_max))
            //             color.r += selectedPixel.r;
            //             color.g += selectedPixel.g;
            //             color.b += selectedPixel.b;
            //             color.a += selectedPixel.a;
            //             count++;
            //         }
            //     }
            // }

            const selectedPixel = getRGBA(imageData.data, convertXYToIndex({x: x_start, y: y_start}, x_max))

            //
            // // 평균 색상 구하기
            // color.r = Math.round(color.r / count);
            // color.g = Math.round(color.g / count);
            // color.b = Math.round(color.b / count);
            // color.a = Math.round(color.a / count);

            // 평균 적용
            for (let dy = 0; dy < pixelSize; dy++) {
                for (let dx = 0; dx < pixelSize; dx++) {
                    const nx = x_start + dx;
                    const ny = y_start + dy;
                    // applyColor(imageData.data, convertXYToIndex({x: nx, y: ny}, x_max), color);
                    applyColor(imageData.data, convertXYToIndex({x: nx, y: ny}, x_max), selectedPixel);
                }
            }

        }
    }

}

export default PixelFilter;