package com.example.demotywatoryv2.services.converters.update;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.put.UpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ConvertRequestToDemot {

    public DemotywatorEntity convert(DemotywatorEntity demotywatorEntity, UpdateRequest updateRequest) {

        demotywatorEntity.setTopText(updateRequest.getTopText());
        demotywatorEntity.setImagePath(updateRequest.getImagePath());
        demotywatorEntity.setBottomText(updateRequest.getBottomText());

        return demotywatorEntity;
    }
}
