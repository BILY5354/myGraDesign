package com.cduy.blog.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.cduy.blog.entity.Article;

/**
 * 文章服务
 * @author CDUY
 * @version 1.0
 */
public interface ArticleService extends IService<Article> {



    /**START MICRO_SERVICE*/
    /**
     * 根据博客id查询远程的user信息
     * */
    Article queryArticleById(Integer articleId);
    /**END MICRO_SERVICE*/
}
