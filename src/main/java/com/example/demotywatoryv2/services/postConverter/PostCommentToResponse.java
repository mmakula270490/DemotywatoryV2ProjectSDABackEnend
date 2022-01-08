package com.example.demotywatoryv2.services.postConverter;

import com.example.demotywatoryv2.model.dao.entity.CommentsEntity;
import com.example.demotywatoryv2.model.dao.post.PostCommentResponse;
import org.springframework.stereotype.Component;

@Component
public class PostCommentToResponse {

    public PostCommentResponse convert(CommentsEntity comment){
        PostCommentResponse response = new PostCommentResponse();
        response.setId(comment.getId());
        response.setContent(comment.getContent());

        return response;
    }
}
