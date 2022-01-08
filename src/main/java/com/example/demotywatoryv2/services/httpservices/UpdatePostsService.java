package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.put.UpdateRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateResponse;
import com.example.demotywatoryv2.model.exceptions.PostNotExistException;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import com.example.demotywatoryv2.services.converters.update.ConvertRequestToDemot;
import com.example.demotywatoryv2.services.converters.update.ConvertRequestToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostsService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    @Autowired
    private ConvertRequestToDemot updateRequestToDemot;

    @Autowired
    private ConvertRequestToResponse updateRequestToUpdateResponse;

    public UpdateResponse updateDemotywator(Long postId, UpdateRequest updateRequest){

        DemotywatorEntity demotywatorEntity = demotywatorEntityRepository.findById(postId)
                .orElseThrow(() -> new PostNotExistException());
        updateRequestToDemot.convert(demotywatorEntity, updateRequest);
        demotywatorEntityRepository.save(demotywatorEntity);

        return updateRequestToUpdateResponse.convert(postId, updateRequest);
    }
}
