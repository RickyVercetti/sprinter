package com.prueba.sprinter.rest.repository;

import com.prueba.sprinter.rest.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
}
