package com.example.android.miwok;

public class Word {
    private String defaultTranslation;
    private String mewokTranslation;

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMewokTranslation() {
        return mewokTranslation;
    }

    public Word(String defaultTranslation, String mewokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.mewokTranslation = mewokTranslation;
    }
}
