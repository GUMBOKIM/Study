const fn = {
    add : (num1, num2) => num1 + num2,
    makeUser: (name, age) => ({name, age, gender: undefined}),
    throwNewError: () => {throw new Error("test")},
    getName: callback => {
        const name = "Mike";
        setTimeout(() => callback(name), 10);
    },
    getAge : () => {
        const age = 30;
        return new Promise((res, rej) => {
            setTimeout(() => {
                // res(age);
                rej("error");
            }, 10);
        });
    }
};

module.exports = fn;