package com.cduy.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cduy.blog.dao.ArticleTagDao;
import com.cduy.blog.entity.ArticleTag;
import com.cduy.blog.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * @author CDUY
 * @version 1.0
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag>implements ArticleTagService {
}
