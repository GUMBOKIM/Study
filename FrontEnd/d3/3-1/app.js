// const pBrowser = document.querySelector('p');
// console.log(pBrowser);

// const pD3 = d3.select('p');
// console.log(pD3);

// const body = d3.select('body').append('p');
// console.log(body);

const el = d3
    .select('body')
    .append('p')
    .attr('name', 'test')
    .attr('class', 'foo')
    .text('Hello World')
    .classed('class1', true)
    .classed('class2', true)
    .style('color', 'red')
    .style('background-color', 'blue');