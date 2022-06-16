export const createRandomNumber = (max: number) => {
    return Math.floor(Math.random() * max) + 1
}

export const sleep = <T>(input: T, sleepTime: number): Promise<T> => {
    return new Promise((resolve) => setTimeout(() => {
            resolve(input);
        }, sleepTime)
    )
}