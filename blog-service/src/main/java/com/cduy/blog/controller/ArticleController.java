package com.cduy.blog.controller;


import com.cduy.blog.entity.Article;
import com.cduy.blog.service.ArticleService;
import com.cduy.blog.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
@Api(tags = "文章模块")
@RestController
/*@RequestMapping("/articles")*/
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * cduy
     * 查看首页博客
     */
    @GetMapping("/articles")
    public Result<List<Article>> getAll() {
        System.out.println("get all article");
        return Result.ok(articleService.list());
    }

    /**
     * cduy
     * 根据文章id查询
     * */
    @GetMapping("/articles/{articleId}")
    public Result queryArticleByArticleId(@PathVariable("articleId") Integer articleId) {
        return Result.ok(articleService.queryArticleById(articleId));
    }



}
