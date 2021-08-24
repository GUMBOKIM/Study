package com.board.mssql.controller;


import com.board.mssql.mapper.BoardMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    BoardMapper boardMapper;

    @GetMapping("board/list")
    public String getBoardList() {

        String boardList = new Gson().toJson(boardMapper.findBoardList());
        System.out.println(boardList);
        return boardList;
    }

    @PostMapping("board/create")
    public void createBoard(@RequestBody String name) {
        System.out.println(name);
        boardMapper.createBoard(name);
    }


}
