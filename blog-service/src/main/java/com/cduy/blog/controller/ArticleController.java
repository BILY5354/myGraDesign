package com.cduy.blog.controller;

import com.cduy.blog.controller.utils.R;
import com.cduy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CDUY
 * @version 1.0
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public R getAll() {
        return new R(true,articleService.list());
    }
}
