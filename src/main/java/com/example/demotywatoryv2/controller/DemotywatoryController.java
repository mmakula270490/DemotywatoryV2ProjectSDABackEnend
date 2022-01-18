package com.example.demotywatoryv2.controller;

import com.example.demotywatoryv2.model.dao.get.*;
import com.example.demotywatoryv2.model.dao.post.PostCommentRequest;
import com.example.demotywatoryv2.model.dao.post.PostCommentResponse;
import com.example.demotywatoryv2.model.dao.post.PostRequest;
import com.example.demotywatoryv2.model.dao.post.PostResponse;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateCommentResponse;
import com.example.demotywatoryv2.model.dao.put.UpdateRequest;
import com.example.demotywatoryv2.model.dao.put.UpdateResponse;
import com.example.demotywatoryv2.services.httpservices.*;
import com.example.demotywatoryv2.services.storage.StorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class DemotywatoryController {

    @Autowired
    private GetPostsService getPostsService;

    @Autowired
    private CreatePostsService createPostsService;

    @Autowired
    private DeletePostsService deletePostsService;

    @Autowired
    private VotesService votesService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private StorageService storageService;

    @GetMapping(path = "/api/posts/{postId}")
    public ResponseEntity<GetResponse> getById(@PathVariable(name = "postId")Long postId){
        return new ResponseEntity<GetResponse>(getPostsService.getById(postId), HttpStatus.OK);
    }

    @GetMapping(path = "/api/posts")
    public ResponseEntity<GetResponseList> getAll(){
        return new ResponseEntity<GetResponseList>(getPostsService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/api/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addNewDemotywator(@Valid
                                                        @RequestPart String topText,
                                                        @RequestPart String bottomText,
                                                        @RequestPart MultipartFile image){

        createPostsService.addNewDemotywator(topText, bottomText, storageService.store(image));
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @PostMapping(path = "/api/posts/{postId}/reactions/voteUp")
    @ResponseStatus(HttpStatus.CREATED)
    public void voteUp(@PathVariable(name= "postId") Long postId){

        votesService.voteUp(postId);
    }

    @PostMapping(path = "/api/posts/{postId}/reactions/voteDown")
    @ResponseStatus(HttpStatus.CREATED)
    public void voteDown(@PathVariable(name= "postId") Long postId){

        votesService.voteDown(postId);
    }

    @GetMapping(path = "api/posts/{postId}/reactions")
    public ResponseEntity<GetReactionsResponse> getReactions(@PathVariable(name = "postId")Long postId){

        return new ResponseEntity<GetReactionsResponse>(votesService.getReactions(postId), HttpStatus.OK);
    }

    @PostMapping(path = "/api/posts/{postId}/comments")
    public ResponseEntity<PostCommentResponse> addCommentToPost(@PathVariable(name= "postId") Long postId, @RequestBody PostCommentRequest postCommentRequest){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            return new ResponseEntity<PostCommentResponse>(commentsService.addCommentToPost(postId, postCommentRequest, usersService.getUserIdByName(currentUserName)), HttpStatus.CREATED);

        }
        return new ResponseEntity<PostCommentResponse>(new PostCommentResponse(), HttpStatus.FORBIDDEN);
    }

    @GetMapping(path = "/api/posts/{postId}/comments")
    public ResponseEntity<List<GetCommentsResponse>> getAllPostComments(@PathVariable(name= "postId") Long postId){

        return new ResponseEntity<List<GetCommentsResponse>>(commentsService.getAllPostComments(postId), HttpStatus.OK);
    }

    @GetMapping(path = "/api/comments/{commentId}")
    public ResponseEntity<GetCommentsResponse> getPostComment(@PathVariable(name= "commentId") Long commentId){

        return new ResponseEntity<GetCommentsResponse>(commentsService.getPostComment(commentId), HttpStatus.OK);
    }

    @PutMapping(path = "/api/comments/{commentId}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@Valid @PathVariable("commentId") Long commentId, @RequestBody UpdateCommentRequest updateCommentRequest){

        return new ResponseEntity<UpdateCommentResponse>(commentsService.updateComment(commentId, updateCommentRequest), HttpStatus.CREATED);
    }
}