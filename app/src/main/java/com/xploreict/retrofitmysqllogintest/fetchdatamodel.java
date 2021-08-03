package com.xploreict.retrofitmysqllogintest;

public class fetchdatamodel {
    String id,name,designation,images;

    public fetchdatamodel(String id, String name, String designation, String images) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
