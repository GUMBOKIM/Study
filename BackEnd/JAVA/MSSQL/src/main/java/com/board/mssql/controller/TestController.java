package com.board.mssql.controller;

import com.board.mssql.mapper.TestMapper;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class TestController {

    TestMapper testMapper;

    @GetMapping("test/procedure")
    public void testMapper1() {
        System.out.println(testMapper.testProcedure());
    }

    @PostMapping("test/allinone")
    public void testMapper2() {

        testMapper.insertAllInOne("PID","PPW","자유", "똥글", "똥글");
    }
}
