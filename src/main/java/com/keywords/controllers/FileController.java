package com.keywords.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {
    @PostMapping("upload-file")
    public ResponseEntity<String> uploadFile() {
        return ResponseEntity.ok("ok");
    }
}
