package com.leesan.picApp.repository;

import com.leesan.picApp.model.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PicturesRepository extends CrudRepository<Picture, Integer> {



}
