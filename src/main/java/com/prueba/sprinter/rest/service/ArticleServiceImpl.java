package com.prueba.sprinter.rest.service;

import com.prueba.sprinter.rest.dto.Article;
import com.prueba.sprinter.rest.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ArticleServiceImpl implements  ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleByCode(String code) {
        return articleRepository.findById(code).orElseThrow(() ->{throw new RuntimeException();});
    }

    @Override
    public Article modifyArticle(String code, Article article) {
        Article articuloBuscado  = articleRepository.findById(code).get();
        articuloBuscado.setName(article.getName());
        articuloBuscado.setSize(article.getSize());
        articuloBuscado.setColor(article.getColor());
        articuloBuscado.setPrice(article.getPrice());
        return articleRepository.save(articuloBuscado);
    }

    @Override
    public boolean deleteCustomerByCode(String code) {

        try{
            articleRepository.deleteById(code);
            log.info("Artículo eliminado correctamente");
            return true;
        }catch (Exception e){
            log.error("Error al eliminar el artículo");
            return false;
        }
    }
}
