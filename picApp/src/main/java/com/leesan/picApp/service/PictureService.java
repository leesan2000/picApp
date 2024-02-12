package com.leesan.picApp.service;

import com.leesan.picApp.model.Picture;
import com.leesan.picApp.repository.PicturesRepository;
import org.springframework.stereotype.Service;

import java.util.*;

//@Component
@Service
public class PictureService {

    private final PicturesRepository picturesRepository;

    public PictureService(PicturesRepository picturesRepository){
        this.picturesRepository = picturesRepository;
    }
    public Iterable<Picture> get(){
        return picturesRepository.findAll();
    }

    public Picture get(Integer id){
        return picturesRepository.findById(id).orElse(null);
    }


    public void remove(Integer id) {
        picturesRepository.deleteById(id);

    }

    public Picture save(String fileName, String contentType, byte[] data) {
        Picture picture = new Picture();
        picture.setFileName(fileName);
        picture.setContentType((contentType));
        picture.setData(data);
        picturesRepository.save(picture);
        return picture;
    }

}
