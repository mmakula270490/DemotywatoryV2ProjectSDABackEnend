package com.example.demotywatoryv2.model.dao.post;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostRequest {

    private String topText;

    private String bottomText;

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }
}
