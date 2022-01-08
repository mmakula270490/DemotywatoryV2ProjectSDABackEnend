package com.example.demotywatoryv2.services.converters.update;

import com.example.demotywatoryv2.model.dao.put.UpdateRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class ConvertRequestToResponse {

    public UpdateResponse convert(Long postId, UpdateRequest updateRequest) {

        UpdateResponse updateResponse =  new UpdateResponse();

        updateResponse.setId(postId);
        updateResponse.setTopText(updateRequest.getTopText());
        updateResponse.setImagePath(updateRequest.getImagePath());
        updateResponse.setBottomText(updateRequest.getBottomText());

        return updateResponse;
    }
}
