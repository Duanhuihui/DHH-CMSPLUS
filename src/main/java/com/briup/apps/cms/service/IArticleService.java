package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.ArticlePreview;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {
	List<Article> findAll();
	void saveOrUpddate(Article articel);
	
	List<ArticleExtend> cascadeFindAll();
	
	ArticleExtend findById(long id);
	
	void add(Article article);
	
	void update(Article article);
	
	void remove(long articleId) throws CustomerException;
	
	List<ArticlePreview> preview();
	
	void saveOrUpdate(Article article) throws CustomerException;
	void check(long articleId, String status) throws CustomerException;

}
