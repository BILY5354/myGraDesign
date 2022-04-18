package com.cduy.blog.strategy;

import com.cduy.blog.dto.ArticleSearchDTO;

import java.util.List;

/**
 * 搜索策略
 * @author CDUY
 * @version 1.0
 */
public interface SearchStrategy {
    /**
     * 搜索文章
     *
     * @param keywords 关键字
     * @return {@link List <ArticleSearchDTO>} 文章列表
     */
    List<ArticleSearchDTO> searchArticle(String keywords);
}
