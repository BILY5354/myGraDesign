package com.cduy.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cduy.blog.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 文章标签
 * @author CDUY
 * @version 1.0
 */
@Repository
public interface ArticleTagDao extends BaseMapper<ArticleTag> {
}
