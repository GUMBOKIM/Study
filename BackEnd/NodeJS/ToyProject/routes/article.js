const express = require("express");
const path = require("path");
const { send } = require("process");

const { Board, Article } = require("../models");

const router = express.Router();
const article_path = "../views/article/";

router.get("/post", async (req, res, next) => {
  try {
    const boardList = await Board.findAll({ raw: true });
    res.locals.boardList = boardList;
    res.render(path.join(__dirname, article_path + "article_post.html"));
  } catch (error) {
    console.error(error);
    next(error);
  }
});

router.post("/post", async (req, res, next) => {
  console.log(req.body);
  try {
    Article.create({
      title: req.body.title,
      content: req.body.content,
      boardid: req.body.board,
      writer: 1,
    });
    res.redirect(`/board/${req.body.board}`);
  } catch {
    console.error(error);
    next(error);
  }
});

router.get("/modify/:id", (req, res) => {
  res.sendFile(path.join(__dirname, article_path + "article_modify.html"));
});

router.post("/modify", (req, res) => {
  console.log(`${req.body.title}, ${req.body.content}`);
  res.redirect("/article/1");
});

router.get("/:articleId", async (req, res, next) => {
  try {
    const article = await Article.findOne({ raw : true,
      where : {
          id : req.params.articleId
      }
    });
    res.locals.article = article;
    res.render(path.join(__dirname, article_path + "article_read.html"));
  } catch (error) {
    console.error(error);
    next(error);
  }
});

module.exports = router;
