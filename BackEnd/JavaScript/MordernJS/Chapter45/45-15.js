new Promise((_, reject) => reject(new Error("rejected Eror")))
    .catch((e) => console.log(e));
