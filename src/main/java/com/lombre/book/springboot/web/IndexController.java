package com.lombre.book.springboot.web;

import com.lombre.book.springboot.config.auth.LoginUser;
import com.lombre.book.springboot.config.auth.dto.SessionUser;
import com.lombre.book.springboot.posts.service.PostsService;
import com.lombre.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    /**
     * 화면 이동_메인 페이지
     */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("loginUserName", user.getName());
        }

        return "index";
    }

    /**
     * 화면 이동_글 등록 페이지
     */
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    /**
     * 화면 이동_글 수정 페이지
     */
    @GetMapping("/posts/update/{id}")
    public String postsSave(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
