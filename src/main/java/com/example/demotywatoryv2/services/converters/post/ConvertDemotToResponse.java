package com.example.demotywatoryv2.services.converters.post;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.post.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class ConvertDemotToResponse {

    public PostResponse convert(DemotywatorEntity demotywatorEntity){
        PostResponse convertedResponse  = new PostResponse();

        convertedResponse.setId(demotywatorEntity.getId());
        convertedResponse.setTopText(demotywatorEntity.getTopText());
        convertedResponse.setBottomText(demotywatorEntity.getBottomText());
        convertedResponse.setImagePath(demotywatorEntity.getImagePath());

        return convertedResponse;
    }
}