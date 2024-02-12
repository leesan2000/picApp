package com.leesan.picApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOS")

public class Picture {

    @JsonIgnore
    private byte[] data;
    @Id
    private Integer id;



    private String ContentType;
    @NotEmpty
    private String fileName;

    public Picture() {
    }

    public Picture(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }
}
