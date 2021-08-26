package com.board.mssql.controller;

import com.board.mssql.mapper.TestMapper;
import com.google.gson.JsonArray;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(hidden = true)
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

    @ResponseBody
    @PostMapping("test/swagger")
    public ResponseEntity testSwagger(@RequestParam("title") String title,
                                                 @RequestParam("content") String content) {

        title = title + "asdasd";
        content = content + "asdasdd";

        JsonArray array = new JsonArray();
        array.add(title);
        array.add(content);

        return new ResponseEntity<>(array , HttpStatus.OK);
    }

}
