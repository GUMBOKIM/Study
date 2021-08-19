const resolvedPromise1 = Promise.resolve([1,2,3]);
resolvedPromise1.then(console.log);

const resolvedPromise2 = new Promise(resolve => resolve([1,2,3]));
resolvedPromise2.then(console.log);

const resolvedPromise3 = Promise.reject(new Error('Error1'));
resolvedPromise3.catch(console.log);

const resolvedPromise4 = new Promise(reject => reject(new Error('Error2')));
resolvedPromise4.catch(console.log);
