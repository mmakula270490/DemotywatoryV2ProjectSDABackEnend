package com.example.demotywatoryv2.controller;

import com.example.demotywatoryv2.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class FileUploadController {

    @Autowired
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/fileUpload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes){

        return new ResponseEntity<String>(storageService.store(file), HttpStatus.OK);
    }
}
