// 비구조화 할당
const example = { a: 123, b: { c: 135, d: 146 } }

const a = example.a
const d = example.b.d;

// 구조 분해
const {a, b: {d}} = example;

arr = [1,2,3,4,5]

const x = arr[0]
const y = arr[1]
const z = arr[2]

const [x,y,z,,,] = arr;