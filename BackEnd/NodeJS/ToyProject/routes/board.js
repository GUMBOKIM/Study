const express = require("express");
const path = require("path");
const { send } = require("process");

const router = express.Router();
const board_path = "../views/board/";

router.get("/", (req,res) => {
    res.sendFile(path.join(__dirname, board_path + "board_main.html"));
});

router.get("/create", (req, res) => {
    res.sendFile(path.join(__dirname, board_path + "board_create.html"));
});

router.post("/create", (req, res) => {
    console.log(req.body.board_name)
    res.redirect("/board/");
})

router.get("/:boardId", (req, res) => {
    console.log(req.params);
    res.sendFile(path.join(__dirname, board_path + "article_list.html"));
});

module.exports = router;