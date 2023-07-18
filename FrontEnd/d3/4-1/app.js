async function draw() {
    // Data
    const dataSet = await d3.json('data.json');

    const xAccessor = d => d.currently.humidity;
    const yAccessor = d => d.currently.apparentTemperature;

    // Dimensions
    let dimensions = {
        width: 800,
        height: 800,
        margin: {
            top: 50,
            bottom: 50,
            left: 50,
            right: 50
        }
    };

    dimensions.ctrWidth = dimensions.width - dimensions.margin.left - dimensions.margin.right;
    dimensions.ctrHeight = dimensions.height - dimensions.margin.top - dimensions.margin.bottom;

    // Scales
    const xScale = d3.scaleLinear()
        .domain(d3.extent(dataSet, xAccessor))
        .rangeRound([0, dimensions.ctrWidth])
        .clamp(true);

    const yScale = d3.scaleLinear()
        .domain(d3.extent(dataSet, yAccessor))
        .rangeRound([dimensions.ctrHeight, 0])
        .nice()
        .clamp(true)

    // Draw Image
    const svg = d3.select('#chart')
        .append('svg')
        .attr('width', dimensions.width)
        .attr('height', dimensions.height);

    const ctr = svg.append('g')
        .attr(
            'transform',
            `translate(${dimensions.margin.left},${dimensions.margin.top})`
        );

    const tooltip = d3.select('#tooltip');

    // Draw Circles
    ctr.selectAll('circle')
        .data(dataSet)
        .join('circle')
        .attr('cx', d => xScale(xAccessor(d)))
        .attr('cy', d => yScale(yAccessor(d)))
        .attr('r', 4)
        .attr('fill', 'red')
        .attr('data-temp', yAccessor);

    // Axes
    const xAxis = d3.axisBottom(xScale)
        .ticks(5)
        .tickFormat(tick => `${tick * 100}%`)
    ;

    const xAxisGroup = ctr.append('g')
        .call(xAxis)
        .style('transform', `translateY(${dimensions.ctrHeight + 5}px)`)
        .classed('axis', true);

    xAxisGroup.append('text')
        .attr('x', dimensions.ctrWidth / 2)
        .attr('y', dimensions.margin.bottom - 10)
        .attr('fill', 'black')
        .text('Humidity');

    const yAxis = d3.axisLeft(yScale)
        .ticks(5);

    const yAxisGroup = ctr.append('g')
        .call(yAxis)
        .style('transform', `translateX(-5px)`)
        .classed('axis', true);

    yAxisGroup.append('text')
        .attr('x', -dimensions.ctrHeight / 2)
        .attr('y', -dimensions.margin.left + 15)
        .attr('fill', 'black')
        .html('Temperature &deg; F')
        .style('transform', 'rotate(270deg)')
        .style('text-anchor', 'middle');

    const delaunay = d3.Delaunay.from(
        dataSet,
        (d) => xScale(xAccessor(d)),
        (d) => yScale(yAccessor(d))
    );

    const voronoi = delaunay.voronoi();
    voronoi.xmax = dimensions.ctrWidth;
    voronoi.ymax = dimensions.ctrHeight;

    ctr.append('g')
        .selectAll('path')
        .data(dataSet)
        .join('path')
        // .attr('stroke', 'black')
        .attr('fill', 'transparent')
        .attr('d', (d, i) => voronoi.renderCell(i))
        .on('mouseenter', function (event, datum) {
            ctr.append('circle')
                .classed('dot-hovered', true)
                .attr('fill', 'blue')
                .attr('cx', xScale(xAccessor(datum)))
                .attr('cy', yScale(yAccessor(datum)))
                .attr('r', 6);

            tooltip
                .style('display', 'block')
                .style('top', yScale(yAccessor(datum)) - 40 + "px")
                .style('left', xScale(xAccessor(datum)) + "px");

            const formatter = d3.format('.2f');
            const dateFormatter = d3.timeFormat('%B %-d, %Y')

            tooltip.select('.metric-humidity span')
                .text(formatter(xAccessor(datum)))

            tooltip.select('.metric-temp span')
                .text(formatter(yAccessor(datum)))

            tooltip.select('.metric-date')
                .text(dateFormatter(datum.currently.time * 1000))
        })
        .on('mouseleave', function (event) {
            ctr.select('.dot-hovered').remove();
            tooltip.style('display', 'none');
        });

}

draw();