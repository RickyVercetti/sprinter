package com.prueba.sprinter.rest.service;

import com.prueba.sprinter.rest.dto.Article;

import java.util.Optional;

public interface ArticleService {

    Article saveArticle(Article article);
    Article getArticleByCode(String code);
    Article modifyArticle(String code, Article article);
    boolean deleteCustomerByCode(String code);
}
