package com.example.android.miwok;

public class Word {
    private String defaultTranslation;
    private String mewokTranslation;
    private int imageResourceId;

    private static final  int NO_IMAGE_PROVIDED = -1;

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMewokTranslation() {
        return mewokTranslation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public Word(String defaultTranslation, String mewokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.mewokTranslation = mewokTranslation;
        this.imageResourceId = NO_IMAGE_PROVIDED;
    }

    public Word(String defaultTranslation, String mewokTranslation, int imageResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.mewokTranslation = mewokTranslation;
        this.imageResourceId = imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
