package com.example.demotywatoryv2.model.dao.post;

import javax.validation.constraints.NotNull;

public class PostCommentRequest {

    @NotNull
    private String comment;

    public String getComment() {
        return comment;
    }

}
