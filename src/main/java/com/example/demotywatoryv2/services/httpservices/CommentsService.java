package com.example.demotywatoryv2.services.httpservices;

import com.example.demotywatoryv2.model.dao.entity.CommentsEntity;
import com.example.demotywatoryv2.model.dao.entity.DemotywatorEntity;
import com.example.demotywatoryv2.model.dao.entity.UserEntity;
import com.example.demotywatoryv2.model.dao.get.GetCommentsResponse;
import com.example.demotywatoryv2.model.dao.post.PostCommentRequest;
import com.example.demotywatoryv2.model.dao.post.PostCommentResponse;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentResponse;
import com.example.demotywatoryv2.model.exceptions.CommentNotExistException;
import com.example.demotywatoryv2.model.exceptions.PostNotExistException;
import com.example.demotywatoryv2.repository.CommentsEntityRepository;
import com.example.demotywatoryv2.repository.DemotywatorEntityRepository;
import com.example.demotywatoryv2.services.getConverter.GetCommentToResponse;
import com.example.demotywatoryv2.services.postConverter.PostCommentToResponse;
import com.example.demotywatoryv2.services.updateConverter.UpdateRequestToComment;
import com.example.demotywatoryv2.services.updateConverter.UpdateRequestToResponseComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private DemotywatorEntityRepository demotywatorEntityRepository;

    @Autowired
    private CommentsEntityRepository commentsEntityRepository;

    @Autowired
    private PostCommentToResponse commentToResponse;

    @Autowired
    private GetCommentToResponse getCommentToResponse;

    @Autowired
    private UpdateRequestToComment updateRequestToComment;

    @Autowired
    private UpdateRequestToResponseComment updateRequestToResponseComment;

    public PostCommentResponse addCommentToPost(Long postId, PostCommentRequest postCommentRequest, UserEntity currentUser){

        DemotywatorEntity demotywator = demotywatorEntityRepository.findById(postId)
                .orElseThrow(()-> new PostNotExistException());
        CommentsEntity comment = new CommentsEntity(postCommentRequest.getComment(), demotywator, currentUser);
        commentsEntityRepository.save(comment);

        return commentToResponse.convert(comment);
    }

    public GetCommentsResponse getPostComment(Long commentId){

        CommentsEntity comment = commentsEntityRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotExistException());

        return getCommentToResponse.convert(comment);
    }

    public List<GetCommentsResponse> getAllPostComments(Long postId){

        DemotywatorEntity demotywator = demotywatorEntityRepository.findById(postId)
                .orElseThrow(()-> new PostNotExistException());

        List<CommentsEntity> comments = commentsEntityRepository.getAllCommentsForPost(postId);
        return getCommentToResponse.convert(comments);
    }

    public UpdateCommentResponse updateComment(Long commentId, UpdateCommentRequest updateCommentRequest){

        CommentsEntity comment = commentsEntityRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotExistException());
        updateRequestToComment.convert(comment, updateCommentRequest);
        commentsEntityRepository.save(comment);
        updateRequestToResponseComment.convert(commentId, updateCommentRequest);

        return new UpdateCommentResponse();
    }
}
