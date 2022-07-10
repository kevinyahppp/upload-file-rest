package com.keywords.controllers;

import com.keywords.models.FileResponse;
import com.keywords.services.IFileSytemStorage;
import com.keywords.services.ProccessFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/resume")
public class FileController {
    @Autowired
    IFileSytemStorage fileSytemStorage;
    @Autowired
    ProccessFileService proccessFileService;

    @PostMapping("/uploadfile")
    public ResponseEntity<FileResponse> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        String upfile = fileSytemStorage.saveFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/download/")
                .path(upfile)
                .toUriString();

        proccessFileService.readPDF(upfile);

        return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(upfile, fileDownloadUri, "File uploaded with success!"));
    }
}
