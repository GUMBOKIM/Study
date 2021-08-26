package com.board.mssql.service.FileService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class UploadService {

    private String uploadDir = "/Users/daeheekim/Desktop/GIt/localUpload";

    public String fileUpload(MultipartFile multipartFile) {
        // 폴더 경로 확인
        File folder = new File(uploadDir);
        String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();

        if (!folder.exists()) {
            folder.mkdir();
        }

        Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(fileName));

        try {
            Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}


