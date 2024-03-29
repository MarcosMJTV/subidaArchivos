package com.gmail.tvmj.marcosvilchez.subidaArchivos.controller;

import com.gmail.tvmj.marcosvilchez.subidaArchivos.services.IUploandFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploandFilesController {

    @Autowired
    IUploandFiles repo;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(repo.fileUpload(file),HttpStatus.OK);
    }
}
