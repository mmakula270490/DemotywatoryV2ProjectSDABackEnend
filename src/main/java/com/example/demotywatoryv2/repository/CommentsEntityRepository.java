package com.example.demotywatoryv2.repository;

import com.example.demotywatoryv2.model.dao.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsEntityRepository  extends JpaRepository<CommentsEntity, Long> {

    @Query("SELECT C FROM CommentsEntity C WHERE POST_ID = ?1")
    List<CommentsEntity> getAllCommentsForPost(Long postId);
}