const data = [10, 20, 30, 40, 50, 60, 70];
// const data = [10, 20, 30];

// const el = d3
//     .selectAll('li')
//     .data(data)
//     .join('li')
// ;

const el = d3.select('ul')
    .selectAll('li')
    .data(data)
    // .join(enter => {
    //         enter
    //             .append('li')
    //             .style('color', 'purple')
    //             .text((D) => D);
    //     },
    //     update => update.style('color', 'green'),
    //     exit => exit.remove()
    // )
    .text((D) => D)
;

el.enter()
    .append('li')
    .text(d => d)
;

el.exit().remove();