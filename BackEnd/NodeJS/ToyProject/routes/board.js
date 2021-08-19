const express = require("express");
const path = require("path");
const { send } = require("process");

const { Board, Article } = require("../models");

const router = express.Router();
const board_path = "../views/board/";

router.get("/", async (req, res, next) => {
  try {
    const boardList = await Board.findAll({ raw : true
    });
    console.log("가져오기 성공");
    console.log(boardList);
    res.locals.boardList = boardList;
    res.render(path.join(__dirname, board_path + "board_main.html"));
  } catch (error) {
    console.error(error);
    next(error);
  }
});

router.get("/create", (req, res) => {
  res.sendFile(path.join(__dirname, board_path + "board_create.html"));
});

router.post("/create", (req, res) => {
  Board.create({
    boardname: req.body.board_name,
  });
  res.redirect("/board/");
});

router.get("/:boardId", async (req, res, next) => {
    try {
      const articleList = await Article.findAll({ raw : true,
        where : {
            boardid : req.params.boardId
        }
      });
      console.log("가져오기 성공");
      console.log(articleList);
      res.locals.articleList = articleList;
      res.render(path.join(__dirname, board_path + "article_list.html"));
    } catch (error) {
      console.error(error);
      next(error);
    }
  });

module.exports = router;
