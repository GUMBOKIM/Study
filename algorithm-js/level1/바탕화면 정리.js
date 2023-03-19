function solution(wallpaper) {
    const xLength = wallpaper[0].length;
    const yLength = wallpaper.length;

    let rux = xLength;
    let ruy = yLength;
    let rdx = 0;
    let rdy = 0;

    for (let y = 0; y < yLength; y++) {
        for (let x = 0; x < xLength; x++) {
            const isExist = wallpaper[y][x] === "#";
            if (isExist) {
                rux = Math.min(rux, x);
                ruy = Math.min(ruy, y);
                rdx = Math.max(rdx, x + 1);
                rdy = Math.max(rdy, y + 1);
            }
        }
    }

    return [ruy, rux, rdy, rdx];
}