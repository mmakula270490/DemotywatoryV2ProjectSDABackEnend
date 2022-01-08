package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.exceptions.PostNotExistException;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePostsService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    public void deleteById(Long postId) {


        DemotywatorEntity demotywatorEntity = demotywatorEntityRepository.findById(postId)
                .orElseThrow(() -> new PostNotExistException());
        demotywatorEntityRepository.delete(demotywatorEntity);
    }
}
