const dotenv = require('dotenv');
dotenv.config;

const express = require('express');
const path = require('path');
// Morgan - 요청과 응답의 상세 정보를 기록
const morgan = require('morgan');
// Cookie-Parser 쿠키를 파싱해줌
const cookieParser = require('cookie-parser');
const session = require('express-session');
const app = express();

// 앱 설정
app.set('port', process.env.PORT || 3000);

app.use(morgan('dev'));
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(session({
    resave: false,
    saveUninitialized: false,
    secret: process.env.COOKIE_SECRET,
    cookie: {
        httpOnly: true,
    },
    name: 'connect.sid'
}))

app.use(express.json());
app.use(express.urlencoded({extended: true}));


// app.use('요청경로', express.static(__dirname, '실제경로'))
// app.use('/', express.static(__dirname, 'public-3030'))

// 미들웨어
app.use((req, res, next) => {
    console.log('모든 요청에 실행 1')
    next();
}, (req, res, next) => {
    console.log('모든 요청에 실행 2')
    next();
}, (req, res, next) => {
    console.log('모든 요청에 실행 3')
    next();
})

app.use('/about', (req, res, next) => {
    console.log('about 요청에 실행')
    next();
})

// 라우터
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html'));
    // 중복으로 보내면(send) 에러 발생
    // ++
    // res.send('안녕하세요')
    // res.json({hello: 'zerocho'});
});

app.get('/about', (req, res) => {
    res.send('hello express!');
});

app.get('/same', (req, res, next) => {
    res.send('똑같은 라우터 테스트');
    next('route');
}, (req, res) => {
    console.log('실행 안된다');
});

app.get('/same', (req, res) => {
    console.log('실행 된다');
});

app.get('/cookie', (req, res, next) => {
    req.cookies
    res.cookie('name', encodeURIComponent('이름입니다'), { 
        expires: new Date(),
        httpOnly: true,
        path:'/cookie'
    })
})

app.get('/error', (req, res) => {
    try {
        console.log(errororororor)
    } catch (error) {
        next(error);
    }
});



// 에러 미들웨어
app.use((req, res, next) => {
    res.status(404).send('404에러 입니당!')
})

app.use((err, req, res, next) => {
    console.error(err);
    res.send('에러 났읍니다..')
})

// 포트 설정
app.listen(app.get('port'), () => {
    console.log('listening on port 3000');
});