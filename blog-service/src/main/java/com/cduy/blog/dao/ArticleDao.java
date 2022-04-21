package com.cduy.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cduy.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author CDUY
 * @version 1.0
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {

}
