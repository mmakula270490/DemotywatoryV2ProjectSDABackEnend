package com.example.demotywatoryv2.model.dao.entity;

import com.example.demotywatoryv2.model.dto.VoteType;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class VotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private DemotywatorEntity post_id;

    @Column(name = "vote_type")
    private String voteType;

    public VotesEntity(DemotywatorEntity post_id, VoteType voteType) {
        this.post_id = post_id;
        this.voteType = voteType.name();
    }

}
