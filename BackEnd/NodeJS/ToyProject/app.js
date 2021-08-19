const express = require("express");
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const dotenv = require('dotenv');
const path = require("path");

dotenv.config();
// 라우터 등록
const userRouter = require('./routes/user');
const boardRouter = require('./routes/board');
const articleRouter = require('./routes/article');

const app = express();
app.set("port", process.env.PORT || 3000);

// Morgan - 개발할때 콘솔로그 찍어줌
// 인수 : dev, combined, common, short, tiny
app.use(morgan('dev'));
// Static - 정적인 파일(CSS, JS 등) 제공 라우터
// app.use('요청 경로', express.static('실제 경로'))
app.use('/', express.static(path.join(__dirname, 'public')));
// body-paser (현재 Express 내부에 내장)
// 요청의 본문에 있는 데이터를 해석해서 req.body로 만들어줌
app.use(express.json());
app.use(express.urlencoded({extended : false}));
// Cookie-parser 
// 요청에 동봉된 쿠키를 해석해 req.cookies 객체로 만든다
app.use(cookieParser(process.env.COOKIE_SECRET));
// express-session - 세션 관리용 미들웨어
app.use(session({
    resave: false,
    saveUninitialized: false,
    secret: process.env.COOKIE_SECRET,
    cookie: {
        httpOnly: true,
        secure: false,
    },
    name: 'session-cookie',
}));

// 라우터 경로
app.use('/user', userRouter);
app.use('/board', boardRouter);
app.use('/article', articleRouter);

// 에러처리 라우터
app.use((req,res, next) => {
    res.status(404).send('Not Found');
});

//전역 미들웨어
app.use((req, res, next) => {
  console.log(process.env.DOT_REQUEST);
  console.log("전역 미들웨어 실행");
  next();
});

app.get("/", (req, res) => {
  // res.send('Hello, Express');
  res.sendFile(path.join(__dirname, "views/index.html"));
});

app.get("/error", (req, res) => {
  throw new Error("에러처리 미들웨어 실행");
});

//에러처리 미들웨어
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).send("Error");
});

app.listen(app.get("port")),
  () => {
    console.log(app.get("port"), "번 포트에서 대기 중");
  };
