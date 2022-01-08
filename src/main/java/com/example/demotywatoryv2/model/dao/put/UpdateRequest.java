package com.example.demotywatoryv2.model.dao.put;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateRequest {
    private String topText;

    @NotNull
    @NotEmpty
    private String imagePath;

    @NotNull
    @NotEmpty
    private String bottomText;

    public String getTopText() {
        return topText;
    }

    public void setTopTex(String topText) {
        this.topText = topText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }
}
