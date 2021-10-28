package com.pdprogramer.dentapp.model.media;

import android.content.Intent;

public class ItemMedia {
    String name;
    int resource;

    public ItemMedia (String namme,int resource) {
        this.name = name;
        this.resource=resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
