package com.pdprogramer.dentapp.model.speak;
import android.media.Image;
import android.widget.ImageView;
public class ItemSpeak {

    private ImageView Img;
    private String TxtG;
    private String TxtP;
    public ItemSpeak(ImageView img, String txtP, String txtG) {
        Img = img;
        TxtP = txtP;
        TxtG = txtG;
    }

    public ImageView getImg() {
        return Img;
    }

    public void setImg(ImageView img) {
        Img = img;
    }

    public String getTxtP() {
        return TxtP;
    }

    public void setTxtP(String txtP) {
        TxtP = txtP;
    }

    public String getTxtG() {
        return TxtG;
    }

    public void setTxtG(String txtG) {
        TxtG = txtG;
    }

}
