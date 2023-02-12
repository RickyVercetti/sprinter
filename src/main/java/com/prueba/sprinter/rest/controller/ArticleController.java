package com.prueba.sprinter.rest.controller;

import com.prueba.sprinter.rest.dto.Article;
import com.prueba.sprinter.rest.service.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {this.articleService = articleService;}

    @PostMapping
    public ResponseEntity saveArticle(@RequestBody Article article) {
        log.info("Artículo creado con código: "+ article.getCode());
        return new ResponseEntity(articleService.saveArticle(article), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity getArticleByCode(@PathVariable("code") String code){
        return new ResponseEntity(articleService.getArticleByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity modifyArticleByCode(@PathVariable("code") String code, @RequestBody Article article){
        return new ResponseEntity(articleService.modifyArticle(code, article), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteArticleByCode(@PathVariable String code){
        boolean response = articleService.deleteCustomerByCode(code);
        if (response){
            return new ResponseEntity( HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
