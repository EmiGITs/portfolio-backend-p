package com.emilianodri.portfoliobackend.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;


    @Override
    @PostConstruct
    public void init() throws IOException {
            rootLocation = Paths.get(mediaLocation);
            Files.createDirectories(rootLocation);
    }

    @Override
    public String store(MultipartFile file) {
        try{
            if(file.isEmpty()){
                throw new RuntimeException("Failed to store empty file.");
            }


            String filename = file.getOriginalFilename();


            if(!filename.strip().equals("encabezado.png") && !filename.strip().equals("insignia.png") && !filename.strip().equals("profile.png")){
                throw new RuntimeException("Tipo de archivo incorrecto.");
            }
            boolean valid=true;

            try {
                Image image = ImageIO.read(file.getInputStream());
                if (image == null) {
                    valid = false;

                }
            } catch(IOException ex) {
                valid = false;

            }

            if(valid==false){
                throw new RuntimeException("No es una imagen.");
            }



            Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store file.", e);
            }
            return filename;
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to store file.", e);
        }

    }

    @Override
    public Resource loadAsResource(String filename) {
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource((file.toUri()));

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("Could not read file "+filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: "+filename);
        }
    }
}
