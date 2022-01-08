package com.example.demotywatoryv2.model.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private DemotywatorEntity post_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    public CommentsEntity() {

    }

    public CommentsEntity(String content, DemotywatorEntity post_id, UserEntity currentUser) {
        this.content = content;
        this.post_id = post_id;
        this.user = currentUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPost_id(DemotywatorEntity post_id) {
        this.post_id = post_id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public DemotywatorEntity getPost_id() {
        return post_id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
