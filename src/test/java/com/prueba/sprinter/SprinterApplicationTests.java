package com.prueba.sprinter;

import com.prueba.sprinter.rest.controller.ArticleController;
import com.prueba.sprinter.rest.dto.Article;
import com.prueba.sprinter.rest.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;

@SpringBootApplication
@Slf4j
class SprinterApplicationTests {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	ArticleService articleService;

	private static final String CREATE_TABLE_SCRIPT = "scripts/create/createTable.sql";


	@Before
	public void before() throws SQLException{
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource(CREATE_TABLE_SCRIPT));
	}
	@Test
	public void createArticleServiceTest() {

		log.info("Iniciando Test createArticleServiceTest....\nCreando nuevo artículo");
		Article articleDto = new Article();
		articleDto.setCode(01);
		articleService.saveArticle(articleDto);
		log.info("Artículo creado correctamente. Se procede a modificar...");
		articleService.modifyArticle("01", articleDto);
		log.info("Artículo modificado correctamente. Se procede a consultar...");
		log.info(articleService.getArticleByCode("01").toString());
		log.info("Procedemos finalmente al borrado del artículo...");
		articleService.deleteCustomerByCode("01");
		log.info("Artículo borrado correcamente");

		Assert.assertEquals(0, this.jdbc.queryForList("SELECT COUNT(*) FROM TSPRIART;").size());
	}

}
