package com.example.demotywatoryv2.repository;

import com.example.demotywatoryv2.model.dao.entity.VotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesEntityRepository extends JpaRepository<VotesEntity, Long> {

    @Query("SELECT COUNT(*) FROM VotesEntity V WHERE POST_ID = ?1 AND VOTE_TYPE ='VOTE_UP'")
    Long getVotesUpSum(Long postId);

    @Query("SELECT COUNT(*) FROM VotesEntity V WHERE POST_ID = ?1 AND VOTE_TYPE ='VOTE_DOWN'")
    Long getVotesDownSum(Long postId);
}
