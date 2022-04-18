package com.cduy.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cduy.blog.clients.UserAuthClient;
import com.cduy.blog.dao.ArticleDao;
import com.cduy.blog.dao.ArticleTagDao;
import com.cduy.blog.dao.CategoryDao;
import com.cduy.blog.dao.TagDao;
import com.cduy.blog.dto.*;
import com.cduy.blog.entity.Article;
import com.cduy.blog.entity.UserAuth;
import com.cduy.blog.service.ArticleService;
import com.cduy.blog.service.ArticleTagService;
import com.cduy.blog.service.RedisService;
import com.cduy.blog.service.TagService;
import com.cduy.blog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    /**START MICRO_SERVICE*/
    /**START 使用Feign远程调用*/
    @Autowired
    private UserAuthClient userAuthClient;
    /**END 使用Feign远程调用*/
    /**END MICRO_SERVICE*/

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleTagDao articleTagDao;
    @Autowired
    private HttpSession session;
    @Autowired
    private RedisService redisService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private MySqlSearchStrategyImpl mySqlSearchStrategyImpl;


    @Override
    public PageResult<ArchiveDTO> listArchives() {
        return null;
    }

    @Override
    public PageResult<ArticleBackDTO> listArticleBacks(ConditionVO condition) {
        return null;
    }

    @Override
    public List<ArticleHomeDTO> listArticles() {
        return null;
    }

    @Override
    public ArticlePreviewListDTO listArticlesByCondition(ConditionVO condition) {
        return null;
    }

    @Override
    public List<ArticleSearchDTO> listArticlesBySearch(ConditionVO condition) {
        return null;
    }

    @Override
    public ArticleVO getArticleBackById(Integer articleId) {
        return null;
    }

    @Override
    public ArticleDTO getArticleById(Integer articleId) {
        return null;
    }

    @Override
    public void saveArticleLike(Integer articleId) {

    }

    @Override
    public void saveOrUpdateArticle(ArticleVO articleVO) {

    }

    @Override
    public void updateArticleTop(ArticleTopVO articleTopVO) {

    }

    @Override
    public void updateArticleDelete(DeleteVO deleteVO) {

    }

    @Override
    public void deleteArticles(List<Integer> articleIdList) {

    }

    /**START MICRO_SERVICE*/
    /**START 使用Feign远程调用*/
    @Override
    public Article queryArticleById(Integer articleId) {
        //1.查询文章
        Article article = articleService.getById(articleId);
        //2.用Feign远程调用
        Result<UserAuth> result = userAuthClient.findById(article.getUserId());
        // 因为返回的数据是 Result 需要处理数据
        String jsonObject = JSON.toJSONString(result.getData());
        UserAuth userAuth = JSON.parseObject(jsonObject, UserAuth.class);
        //3.存入article
        article.setUserAuth(userAuth);
        return article;
    }
    /**END 使用Feign远程调用*/

    /**START 使用RestTemplate远程调用 该方法可读性不高 该用Feign*/
    /*@Autowired
    private RestTemplate restTemplate;

    public Article queryArticleById(Integer articleId) {
        //1.查询文章
        Article article = articleService.getById(articleId);
        //2.远程查询user
        //2.1url地址
        //String url = "http://localhost:81/users/" + article.getUserId();
        String url = "http://userservice/users/" + article.getUserId();
        System.out.println(url);
        //2.2发起调用 因为返回结果被封装成了 Result
        Result<UserAuth> result = restTemplate.getForObject(url, Result.class);
        // 因为返回的数据是 Result 需要处理数据
        String jsonObject = JSON.toJSONString(result.getData());
        UserAuth userAuth = JSON.parseObject(jsonObject, UserAuth.class);
        //3.存入article
        article.setUserAuth(userAuth);
        //4.返回
        return article;
    }*/
    /**END 使用RestTemplate远程调用 该方法可读性不高 该用Feign*/
    /**END MICRO_SERVICE*/
}
