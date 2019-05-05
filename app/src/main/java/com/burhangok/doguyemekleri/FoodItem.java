package com.burhangok.doguyemekleri;

import java.io.Serializable;

public class FoodItem implements Serializable {


    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    private int photo;

    public FoodItem() {
    }

    public FoodItem(String title, int photo, String materials, String cooking) {
        this.title = title;
        this.photo = photo;
        this.materials = materials;
        this.cooking = cooking;
    }

    private String materials;
    private String cooking;



}
