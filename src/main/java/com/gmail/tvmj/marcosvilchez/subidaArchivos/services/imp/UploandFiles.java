package com.gmail.tvmj.marcosvilchez.subidaArchivos.services.imp;

import com.gmail.tvmj.marcosvilchez.subidaArchivos.services.IUploandFiles;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploandFiles implements IUploandFiles {
    @Override
    public String fileUpload(MultipartFile file) throws Exception {
        try{
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileNameOrifinal = file.getOriginalFilename();
            long fileSize = file.getSize();
            long maxFileSize = 9 * 1024 * 1024;
            if(fileSize > maxFileSize){
                return "el archivo sobrepasa el limite";
            }

            if(!fileNameOrifinal.endsWith(".jpg") &&
                    !fileNameOrifinal.endsWith(".jpeg") &&
                    !fileNameOrifinal.endsWith(".png")){
                    return "el archivo no es una imagen";
            }

            String fileExtends = fileNameOrifinal.substring(fileNameOrifinal.lastIndexOf("."));
            String newFileName = fileName + fileExtends;

            File folder = new File("src/main/resources/pictures");
            if(!folder.exists()){
                folder.mkdirs();
            }
            Path path= Paths.get("src/main/resources/pictures/" + newFileName);
            Files.write(path, bytes);

            return "imagen cargada";

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
