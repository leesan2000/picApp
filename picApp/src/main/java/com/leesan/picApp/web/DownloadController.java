package com.leesan.picApp.web;

import com.leesan.picApp.model.Picture;
import com.leesan.picApp.service.PictureService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    private final PictureService pictureService;

    public DownloadController(PictureService pictureService){
        this.pictureService = pictureService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Picture picture = pictureService.get(id);


        byte[] data = picture.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(picture.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(picture.getFileName())
                .build();
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
