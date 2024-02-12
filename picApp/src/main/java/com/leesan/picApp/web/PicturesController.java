package com.leesan.picApp.web;

import com.leesan.picApp.model.Picture;
import com.leesan.picApp.service.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController

public class PicturesController {

    private final PictureService pictureService;

    public PicturesController(PictureService pictureService){
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<Picture> get(){
        return  pictureService.get();
    }

    @GetMapping("/photos/{id}")
    public Picture get(@PathVariable Integer id) {
        Picture picture = pictureService.get(id);
        if (picture == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return picture;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id){
        pictureService.remove(id);
    }

    @PostMapping("/photos")
    public Picture create(@RequestPart("data") MultipartFile file) throws IOException {
        return pictureService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}
