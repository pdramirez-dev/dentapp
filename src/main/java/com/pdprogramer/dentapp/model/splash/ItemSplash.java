package com.pdprogramer.dentapp.model.splash;

public class ItemSplash {
    private String title, description;
    private int image_itm;

    public ItemSplash(String title, String description, int image_itm) {
        this.title = title;
        this.description = description;
        this.image_itm = image_itm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_itm() {
        return image_itm;
    }

    public void setImage_itm(int image_itm) {
        this.image_itm = image_itm;
    }
}
