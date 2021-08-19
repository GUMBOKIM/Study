const express = require("express");
const path = require("path");
const { send } = require("process");

const {User} = require('../models');

const router = express.Router();
const user_path = "../views/user/";

let mem_account = "test";
let mem_password = "test";

router.get("/login", (req, res) => {
  res.sendFile(path.join(__dirname, user_path + "login.html"));
});

router.post("/login", async (req, res, next) => {
  try {
    const user = await User.findOne({ where: { account: req.body.account } });
    if (user && user.password == req.body.password) {
      res.send('성공');
    } else {
      res.status(404).send('유저가 존재하지 않거나 비밀번호가 틀렸습니다.');
    }
  } catch (error) {
    console.error(error);
    next(error);
  }
});

router.get("/join", (req, res) => {
  res.sendFile(path.join(__dirname, user_path + "join.html"));
});

router.post("/join", (req, res) => {
  User.create({
    account : req.body.account,
    nickname : req.body.nickname,
    password : req.body.password,
  })
  res.redirect("/user/login")
});

module.exports = router;