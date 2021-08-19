const { odd, even } = require('./var');

function checkNumber(number) {
    if (number % 2) {
        return odd;
    } else {
        return even;
    }
}

module.exports = checkNumber;