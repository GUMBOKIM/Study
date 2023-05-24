export interface RGBA {
    r: number;
    g: number;
    b: number;
    a: number;
}

export type FilterFunction = (image: ImageData) => void;