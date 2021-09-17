package com.example.springfilter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/a")
    public ResponseEntity aCon() {
        return new ResponseEntity('a',HttpStatus.OK);
    }

    @GetMapping("/b")
    public ResponseEntity bCon() {
        return new ResponseEntity('b',HttpStatus.OK);
    }

    @GetMapping("/c")
    public ResponseEntity cCon() {
        return new ResponseEntity('c',HttpStatus.OK);
    }
}
