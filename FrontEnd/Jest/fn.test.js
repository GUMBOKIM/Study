const fn = require('./fn');

test('1은 1', () => {
    expect(1).toBe(1);
})

test('2 더하기 3은 5', () => {
    expect(fn.add(2,3)).toBe(5);
})

test('3 더하기 3은 5', () => {
    expect(fn.add(3,3)).not.toBe(5);
})

test('이름과 나이를 통해서 객체 반환', () => {
    expect(fn.makeUser('Mike',30)).toEqual({
        name: 'Mike',
        age: 30
    })
})

test('이름과 나이를 통해서 객체 반환', () => {
    expect(fn.makeUser('Mike',30)).not.toStrictEqual({
        name: 'Mike',
        age: 30
    })
})

test('toBeNull', () => {
    expect(null).toBeNull();
})

test('toBeUndefined', () => {
    expect(undefined).toBeUndefined();
})

test('toBeDefined', () => {
    expect('a').toBeDefined();
})


test('toBeTruthy', () => {
    expect(1).toBeTruthy();
})

test('toBeFalsy', () => {
    expect('').toBeFalsy();
})

test('toBeGreaterThan', () => {
    expect(10).toBeGreaterThan(9);
})

test('toBeGreaterThanOrEqual', () => {
    expect(9).toBeGreaterThanOrEqual(9);
})

test('toBeLessThanOrEqual', () => {
    expect(9).toBeLessThanOrEqual(9);
})

test('toBeGreaterThanOrEqual', () => {
    expect(9).toBeLessThan(10);
})

test(`test find 'asdf'`, () => {
    expect("asdfasdfasdf").toMatch(/asdf/);
})

test(`find array`, () => {
    const userList = ["Tom", "Jane", "Kai"];
    expect(userList).toContain("Kai");
})

test(`error test`, () => {
    expect(() => fn.throwNewError()).toThrow("test");
})

test('asynchronous resolve test1', (done) => {
    function callback(name) {
        expect(name).toBe("Mike");
        done();
    }
    fn.getName(callback);
})

// test('asynchronous resolve test2', () => {
//     // return fn.getAge().then(age => {
//     //     expect(age).toBe(30);
//     // })
//     return expect(fn.getAge())
//         .resolves.toBe(30);
// })

test('asynchronous error test1', () => {
    return expect(fn.getAge())
        .rejects.toMatch("error");
})

test('asynchronous error test2', async () => {
    // const result =  await expect(fn.getAge());
    // expect(result).toBe("error");
    return await expect(fn.getAge())
        .rejects.toMatch("error");
})

const mockFn = jest.fn();

mockFn();
mockFn(1);

test('dd', () => {
    console.log(mockFn.mock.calls);
    expect("dd").toBe("dd");
})