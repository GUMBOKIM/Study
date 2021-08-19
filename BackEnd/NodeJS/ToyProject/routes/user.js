const express = require("express");
const path = require("path");
const { send } = require("process");

const router = express.Router();
const user_path = "../views/user/";

let mem_account = "test";
let mem_password = "test";

router.get("/login", (req, res) => {
  res.sendFile(path.join(__dirname, user_path + "login.html"));
});

router.post("/login", (req, res) => {
    console.log(`account : ${req.body.account}, password : ${req.body.password}`);
  if ((mem_account == req.body.account) & (mem_password == req.body.password)) {
    res.redirect("/");
    console.log("로그인 성공");
  } else {
    res.send("로그인 오류입니다")
    console.log("로그인 실패");
  }

});

router.get("/join", (req, res) => {
  res.sendFile(path.join(__dirname, user_path + "join.html"));
});

router.post("/join", (req, res) => {
  mem_account = req.body.account;
  meme_password = req.body.password;
  console.log(`비밀번호 변경 account : ${mem_account}, password : ${mem_password}`);
  res.redirect("/user/login");
});

module.exports = router;