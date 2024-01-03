package com.gmail.tvmj.marcosvilchez.subidaArchivos.services;

import org.springframework.web.multipart.MultipartFile;

public interface IUploandFiles {
    String fileUpload (MultipartFile file) throws Exception;
}
