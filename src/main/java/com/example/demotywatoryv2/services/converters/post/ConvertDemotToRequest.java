package com.example.demotywatoryv2.services.converters.post;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.post.PostRequest;
import org.springframework.stereotype.Component;

@Component
public class ConvertDemotToRequest {
    public DemotywatorEntity convert(PostRequest postRequest, String imagePath) {

        DemotywatorEntity newDemotywator = new DemotywatorEntity();
        newDemotywator.setTopText(postRequest.getTopText());
        newDemotywator.setImagePath(imagePath);
        newDemotywator.setBottomText(postRequest.getBottomText());

        return newDemotywator;
    }
}
