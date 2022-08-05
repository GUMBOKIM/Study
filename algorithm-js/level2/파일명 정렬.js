function solution(files) {
    let arr = files;
    arr.sort(sort);
    return arr;

    //
    // const pattern = /(\D+)(\d{1,5})/;
    // return files.sort((a, b) => {
    //     let [aHead, aNumber] = a.match(pattern).slice(1, 3);
    //     let [bHead, bNumber] = b.match(pattern).slice(1, 3);
    //     aHead = aHead.toLowerCase();
    //     bHead = bHead.toLowerCase();
    //     if (aHead === bHead && aNumber === bNumber) return 0;
    //     if (aHead === bHead) return aNumber - bNumber;
    //     if (aHead > bHead) return 1;
    //     else return -1;
    // });

}

function parse(file) {
    let length = file.length;

    let numStartIdx = file.search(/[\d]/g);
    let head = file.substring(0, numStartIdx);

    let num = "", tail = "";
    if (numStartIdx != -1) {
        let numEndIdx = numStartIdx + 1;
        while (numEndIdx < length) {
            if (file[numEndIdx].search(/[\d]/g) == -1) break;
            numEndIdx++;
        }
        num = file.substring(numStartIdx, numEndIdx);
        tail = file.substring(numEndIdx);
    }
    console.log(head, num, tail);
    return [head, num, tail];
}

parse("string0")

function sort(file1, file2) {
    let [head1, num1, tail1] = parse(file1);
    let [head2, num2, tail2] = parse(file2);
    if (head1 === "" && head2 === "") return 0;
    else {
        head1 = head1.toUpperCase();
        head2 = head2.toUpperCase();
        if (head1 !== head2) return (head1 > head2) - (head1 < head2);
        else {
            if (num1 !== num2) return parseInt(num1) - parseInt(num2);
            else return 0;
        }
    }
}

parse("foo010bar020.zip");

console.log(solution(["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]));