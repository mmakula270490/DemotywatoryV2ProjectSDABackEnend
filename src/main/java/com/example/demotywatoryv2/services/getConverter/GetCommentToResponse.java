package com.example.demotywatoryv2.services.getConverter;

import com.example.demotywatoryv2.model.dao.entity.CommentsEntity;
import com.example.demotywatoryv2.model.dao.get.GetCommentsResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetCommentToResponse {

    public GetCommentsResponse convert(CommentsEntity comments) {

        GetCommentsResponse response = new GetCommentsResponse();
        response.setId(comments.getId());
        response.setContent(comments.getContent());
        response.setUserId(comments.getUser().getId());
        return response;
    }

    public List<GetCommentsResponse> convert(List<CommentsEntity> comments) {

        List<GetCommentsResponse> response = new ArrayList<GetCommentsResponse>();
        for(CommentsEntity comment: comments)
            response.add(convert(comment));

        return response;
    }
}
