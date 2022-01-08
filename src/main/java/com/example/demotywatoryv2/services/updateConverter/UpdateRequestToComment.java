package com.example.demotywatoryv2.services.updateConverter;

import com.example.demotywatoryv2.model.dao.entity.CommentsEntity;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestToComment {

    public CommentsEntity convert(CommentsEntity comment, UpdateCommentRequest updateCommentRequestt) {

        comment.setContent(updateCommentRequestt.getContent());

        return comment;
    }
}
