package com.example.demotywatoryv2.services.converters.get;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.get.GetResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertDemotToResposne {


    public GetResponse convert(DemotywatorEntity demotywatorEntity) {
        GetResponse convertedResponse = new GetResponse();

        convertedResponse.setId(demotywatorEntity.getId());
        convertedResponse.setTopText(demotywatorEntity.getTopText());
        convertedResponse.setBottomText(demotywatorEntity.getBottomText());
        convertedResponse.setImagePath(demotywatorEntity.getImagePath());

        return convertedResponse;
    }

    public List<GetResponse> convert(List<DemotywatorEntity> demotywators) {
        List<GetResponse> convertedResponseList = new ArrayList<GetResponse>();

        for(DemotywatorEntity demot: demotywators)
            convertedResponseList.add(convert(demot));

        return convertedResponseList;
    }
}
