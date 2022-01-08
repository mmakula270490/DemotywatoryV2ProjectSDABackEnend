package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.post.PostRequest;
import com.example.demotywatoryv2.model.dao.post.PostResponse;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import com.example.demotywatoryv2.services.converters.post.ConvertDemotToRequest;
import com.example.demotywatoryv2.services.converters.post.ConvertDemotToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePostsService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    @Autowired
    private ConvertDemotToResponse demotToPostReponse;

    @Autowired
    private ConvertDemotToRequest demotToPostRequest;

    public PostResponse addNewDemotywator(PostRequest postRequest){

        DemotywatorEntity newDemotywator = demotToPostRequest.convert(postRequest);
        DemotywatorEntity saved = demotywatorEntityRepository.save(newDemotywator);
        PostResponse postResponse = demotToPostReponse.convert(saved);

        return postResponse;
    }
}
