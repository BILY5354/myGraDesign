package com.cduy.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cduy.blog.dao.ArticleDao;
import com.cduy.blog.domain.Article;
import com.cduy.blog.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author CDUY
 * @version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {
}
