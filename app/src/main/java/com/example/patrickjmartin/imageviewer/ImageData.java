package com.example.patrickjmartin.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String name;
    private String stringURI;

    public ImageData(String name, Uri uri) {
        this.name = name;
        this.stringURI = uri.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getStringURI() {
        return Uri.parse(stringURI);
    }

    public void setStringURI(Uri uri) {
        this.stringURI = uri.toString();
    }
}
