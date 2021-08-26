package com.board.mssql.controller;

import com.board.mssql.service.FileService.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Controller
public class UploadController {

    @Autowired
    private UploadService fileService;

    @PostMapping("/upload")
    public String fileUpload(@RequestParam String record,
                           @RequestParam MultipartFile[] files) {

        System.out.println("record = " + record + ", files = " + Arrays.deepToString(files));

        for(int i = 0; i < files.length; i++){
            System.out.println(files[i].getSize());
            System.out.println(files[i].getContentType());
            System.out.println(files[i].getOriginalFilename());
            System.out.println(fileService.fileUpload(files[i]));
        }

        return "redirect:/";
    }
}
