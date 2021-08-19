const express = require("express");
const path = require("path");
const { send } = require("process");

const router = express.Router();
const article_path = "../views/article/";

router.get("/post", (req,res) => {
    res.sendFile(path.join(__dirname, article_path + "article_post.html"));
});

router.post("/post", (req, res) => {
    console.log(`${req.body.title}, ${req.body.content}`);
    res.redirect('/article/1');
});

router.get("/modify", (req,res) => {
    res.sendFile(path.join(__dirname, article_path + "article_modify.html"));
});

router.post("/modify", (req,res) => {
    console.log(`${req.body.title}, ${req.body.content}`);
    res.redirect('/article/1');
});

router.get("/:id", (req, res) => {
    console.log(req.params);
    if(req.params == 1){
    res.sendFile(path.join(__dirname, article_path + "article_read.html"));
    } else {
        throw new Error("없는 게시글입니다.");
    }
});

module.exports = router;