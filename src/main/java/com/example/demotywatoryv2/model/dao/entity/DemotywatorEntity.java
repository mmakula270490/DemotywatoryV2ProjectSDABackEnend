package com.example.demotywatoryv2.model.dao.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "demotywator")
public class DemotywatorEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "top_text")
   private String topText;

   @Valid
   @NotNull
   @NotEmpty
   @Column(name = "image_path")
   private String imagePath;

   @Valid
   @NotNull
   @NotEmpty
   @Column(name = "bottom_text")
   private String bottomText;

   @OneToMany(mappedBy="post_id")
   private Set<VotesEntity> votes;

   @OneToMany(mappedBy="post_id")
   private Set<CommentsEntity> comments;

   public DemotywatorEntity() {
   }

   public DemotywatorEntity(Long id, String topText, String imagePath, String bottomText) {
      this.topText = topText;
      this.id = id;
      this.imagePath = imagePath;
      this.bottomText = bottomText;
   }

   public String getTopText() {
      return topText;
   }

   public void setTopText(String topText) {
      this.topText = topText;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getImagePath() {
      return imagePath;
   }

   public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
   }

   public String getBottomText() {
      return bottomText;
   }

   public void setBottomText(String bottomText) {
      this.bottomText = bottomText;
   }
}
