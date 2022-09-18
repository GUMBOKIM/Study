function solution(orders) {
    const studentCount = orders.length;
    const remainStudents = new Set();
    for (let i = 0; i < studentCount; i++) remainStudents.add(i);
    let voteExecuteCount = 0;

    while(true) {
        voteExecuteCount ++;
        let voteResult = createVoteResult(remainStudents, orders);
        let electedStudent = electStudent(voteResult, studentCount);
        let dropStudent = selectDropStudent(voteResult);
        remainStudents.delete(dropStudent);
        orders = createNextOrders(dropStudent, orders);
        if(electedStudent != -1) return [voteExecuteCount, electedStudent];
    }
}

const createVoteResult = (remainStudents, orders) => {
    let voteResult = new Map();
    remainStudents
        .forEach(student => voteResult.set(student, 0));
    orders
        .map(order => order[0])
        .forEach(student => voteResult.set(student, voteResult.get(student) + 1));
    return voteResult;
}

const createNextOrders = (dropStudent, orders) => {
    const newOrders = orders.map(order => {
        let newOrder = [];
        order.forEach(student => {
            if(student !== dropStudent) newOrder.push(student)
        });
        return newOrder;
    });
    return newOrders;
}


const selectDropStudent = (voteResult) =>  {
    let dropStudent = Number.MAX_VALUE;
    let dropStudentCount = Number.MAX_VALUE;

    voteResult.forEach((count, student) => {
        if(dropStudentCount > count) {
            dropStudent = student;
            dropStudentCount = count;
        } else if(dropStudentCount == count){
            if(dropStudent > student) dropStudent = student;
        }
    })
    return dropStudent;
}

const electStudent = (voteResult, studentCount) => {
    let halfStudentCount = Math.ceil(studentCount / 2);
    let electedStudent = -1;

    voteResult.forEach((count, studentIndex) => {
        if(count >= halfStudentCount) {
            if(studentIndex > electedStudent) electedStudent = studentIndex;
        }
    })
    return electedStudent
}

console.log(solution([1]))


