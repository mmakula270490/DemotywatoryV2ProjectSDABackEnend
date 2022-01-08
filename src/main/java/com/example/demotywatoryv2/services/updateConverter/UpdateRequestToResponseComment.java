package com.example.demotywatoryv2.services.updateConverter;

import com.example.demotywatoryv2.model.dao.put.UpdateCommentRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentResponse;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestToResponseComment {

    public UpdateCommentResponse convert(Long commentId, UpdateCommentRequest updateCommentRequest) {

        UpdateCommentResponse updateCommentResponse =  new UpdateCommentResponse();

        updateCommentResponse.setId(commentId);
        updateCommentResponse.setContent(updateCommentRequest.getContent());

        return updateCommentResponse;
    }
}
