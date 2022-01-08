package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.get.GetReactionsResponse;
import com.example.demotywatoryv2.model.dao.get.GetResponse;
import com.example.demotywatoryv2.model.dao.get.GetResponseList;
import com.example.demotywatoryv2.model.exceptions.PostNotExistException;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import com.example.demotywatoryv2.repository.VotesEntityRepository;
import com.example.demotywatoryv2.services.converters.get.ConvertDemotToResposne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPostsService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    @Autowired
    private ConvertDemotToResposne demotToGetResposne;

    @Autowired
    private VotesEntityRepository votesEntityRepository;

    public GetResponse getById(Long id) {

        DemotywatorEntity demotywatorEntity = demotywatorEntityRepository.findById(id)
                .orElseThrow(() -> new PostNotExistException());
        GetResponse response = demotToGetResposne.convert(demotywatorEntity);

        return response;
    }

    public GetResponseList findAll(){

        List<DemotywatorEntity> demotywators = demotywatorEntityRepository.findAll();
        GetResponseList getResponseList = new GetResponseList();
        getResponseList.setPosts(demotToGetResposne.convert(demotywators));

        return getResponseList;
    }
}
