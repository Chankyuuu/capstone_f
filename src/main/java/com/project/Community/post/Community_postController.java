package com.project.Community.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Community_postController {

    private final Community_postService Community_postService;

    @GetMapping("/community_post/list")
    public String list(Model model) {
        List<Community_post> community_postList = this.Community_postService.getList();
        model.addAttribute("community_postList", community_postList);
        return "community_post_list";
    }

    @GetMapping(value = "/community_post/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Community_post Community_post = this.Community_postService.getCommunity_post(id);
        model.addAttribute("Community_post", Community_post);
        return "community_post_detail";
    }

    @GetMapping("/community_post/create")
    public String Community_postCreate() {
        return "community_post_form";
    }

    @PostMapping("/community_post/create")
    public String Community_postCreate(@RequestParam String subject, @RequestParam String content, @RequestParam String password) {
        this.Community_postService.create(subject, content, password);
        return "redirect:/community_post/list"; // 질문 저장후 질문목록으로 이동
    }

    @GetMapping("/community_post/edit/{id}")
    public String Community_postEdit(@PathVariable("id") Integer id, Model model) {
        Community_post existingPost = Community_postService.getCommunity_post(id);
         if (existingPost != null) {
            model.addAttribute("post", existingPost);
            return "community_post_edit_form";
        } else {
            return "redirect:/community_post/list";
        }
    }

    @PostMapping("/community_post/edit/{id}")
    public String Community_postEdit(@PathVariable("id") Integer id, @RequestParam String password, @RequestParam String subject, @RequestParam String content, Model model) {
        Community_post existingPost = Community_postService.getCommunity_post(id);
        if (existingPost != null) {
        if (password.equals(existingPost.getPassword())) {
            this.Community_postService.modify(existingPost, subject, content);
            return "redirect:/community_post/detail/{id}";
        } else {
            return "redirect:/community_post/detail/{id}";
        }
        } else {
            return "redirect:/community_post/detail/{id}";
        }
    }

    @PostMapping("/community_post/delete/{id}")
    public String Community_postDelete(@PathVariable("id") Integer id, @RequestParam String password) {
        Community_post existingPost = Community_postService.getCommunity_post(id);
         if (existingPost != null) {
            if (password.equals(existingPost.getPassword())) {
                this.Community_postService.delete(existingPost);
            return "redirect:/community_post/list";
        } else {
            // 비밀번호가 틀렸을 때 경고 메시지를 리디렉션 파라미터로 추가
            return "redirect:/community_post/detail/{id}?error=비밀번호가 일치하지 않습니다.";
        }
    } else {
        return "redirect:/community_post/detail/{id}";
    }
}
}
