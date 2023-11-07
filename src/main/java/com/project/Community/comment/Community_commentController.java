package com.project.Community.comment;

import com.project.Community.post.Community_post;
import com.project.Community.post.Community_postService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/community_comment")
@RequiredArgsConstructor
@Controller
public class Community_commentController {
    
    private final Community_postService Community_postService;
    private final Community_commentService Community_commentService;

    @PostMapping("/create/{id}")
    public String createCommunitycomment(Model model, @PathVariable("id") Integer id, @RequestParam String content, @RequestParam String password) {
        Community_post Community_post = this.Community_postService.getCommunity_post(id);
        this.Community_commentService.create(Community_post, content, password); 
        return String.format("redirect:/community_post/detail/%s", id);
    }
}
