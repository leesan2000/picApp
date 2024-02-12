package com.leesan.picApp.service;

import com.leesan.picApp.model.Picture;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class PictureService {
    private Map<String, Picture> db = new HashMap<>() {{
        put("1", new Picture("1", "hello.jpg"));

    }};

    public Collection<Picture> get(){
        return db.values();
    }

    public Picture get(String id){
        return db.get(id);
    }


    public Picture remove(String id) {
        return db.remove(id);
    }

    public Picture save(String fileName, String contentType, byte[] data) {
        Picture picture = new Picture();
        picture.setId(UUID.randomUUID().toString());
        picture.setFileName(fileName);
        picture.setContentType((contentType));
        picture.setData(data);
        db.put(picture.getId(), picture);
        return picture;
    }

}
