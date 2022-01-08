package com.example.demotywatoryv2.model.dao.get;

import java.util.List;

public class GetCommentsResponseList {

    private List<GetCommentsResponse> commentsList;

    public List<GetCommentsResponse> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<GetCommentsResponse>  commentsList) {

        this.commentsList = commentsList;
    }
}
