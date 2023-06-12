package edu.poly.foregroundservicetesttixoa.Objects;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String single;
    private int image;
    private int resourse;

    public Song(String title, String single, int image, int resourse) {
        this.title = title;
        this.single = single;
        this.image = image;
        this.resourse = resourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getResourse() {
        return resourse;
    }

    public void setResourse(int resourse) {
        this.resourse = resourse;
    }
}
