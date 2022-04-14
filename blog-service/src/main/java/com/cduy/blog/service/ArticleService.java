package com.cduy.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cduy.blog.domain.Article;

/**
 * @author CDUY
 * @version 1.0
 */
public interface ArticleService extends IService<Article> {

    /**
     * 根据博客id查询远程的user信息
     * */
    Article queryArticleById(Integer articleId);
}
