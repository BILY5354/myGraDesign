package com.cduy.blog.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cduy.blog.dao.ArticleDao;
import com.cduy.blog.entity.Article;
import com.cduy.blog.service.ArticleService;
import com.cduy.feign.clients.UserAuthClient;
import com.cduy.feign.domain.UserAuth;
import com.cduy.feign.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private ArticleService articleService;
    /**END 使用Feign远程调用*/
    /**END MICRO_SERVICE*/



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
