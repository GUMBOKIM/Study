const http = require('http');
const fs = require('fs').promises;

const server = http.createServer(async (req, res) => {
    try {
        res.writeHead(200, { 'Content-Type': 'text/html; charset = utf8' });
        const data = await fs.readFile('./server2.html');
        res.end(data);
    } catch (err) {
        console.error(err);
        res.writeHead(200, { 'Content-Type': 'text/html; charset = utf8' });
        res.err(err.message);
    }
})
    .listen(8080);

server.on('listening', () => {
    console.log('8080번 포트에서 대기중')
});
server.on('error', (error) => {
    console.log(error)
});