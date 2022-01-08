package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.entity.VotesEntity;
import com.example.demotywatoryv2.model.dao.get.GetReactionsResponse;
import com.example.demotywatoryv2.model.dto.VoteType;
import com.example.demotywatoryv2.model.exceptions.PostNotExistException;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import com.example.demotywatoryv2.repository.VotesEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotesService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    @Autowired
    private VotesEntityRepository votesEntityRepository;

    public void voteUp(Long postId){

        DemotywatorEntity demotywator = demotywatorEntityRepository.findById(postId)
                .orElseThrow(() -> new PostNotExistException());

        VotesEntity vote =  new VotesEntity(demotywator, VoteType.VOTE_UP);

        votesEntityRepository.save(vote);
    }

    public void voteDown(Long postId){

        DemotywatorEntity demotywator = demotywatorEntityRepository.findById(postId)
                .orElseThrow(() -> new PostNotExistException());

        VotesEntity vote =  new VotesEntity(demotywator, VoteType.VOTE_DOWN);

        votesEntityRepository.save(vote);
    }

    public GetReactionsResponse getReactions(Long postId){

        demotywatorEntityRepository.findById(postId)
                .orElseThrow(() -> new PostNotExistException());

        Long votesUpSum = votesEntityRepository.getVotesUpSum(postId);
        Long votesDownSum = votesEntityRepository.getVotesDownSum(postId);
        Long balance =  /*Math.abs(*/votesUpSum - votesDownSum/*)*/; //Remains for future

        return new GetReactionsResponse(votesUpSum, votesDownSum, balance);
    }
}
