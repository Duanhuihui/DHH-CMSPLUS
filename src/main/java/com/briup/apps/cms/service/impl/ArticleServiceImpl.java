package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.ArticlePreview;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class ArticleServiceImpl implements IArticleService{
	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	

	@Override
	public List<Article> findAll() {
		
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public void saveOrUpddate(Article articel) {
		
		
	}

	@Override
	public List<ArticleExtend> cascadeFindAll() {
		
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
	
		return articleExtendMapper.selectById(id);
	}

	@Override
	public void add(Article article) {
		articleExtendMapper.insert(article);
		
	}

	@Override
	public void update(Article article) {
		articleMapper.updateByPrimaryKey(article);
		
	}

	@Override
	public void remove(long articleId) {
		if(articleMapper.selectByPrimaryKey(articleId) != null) {
			articleMapper.deleteByPrimaryKey(articleId);
		}else {
			throw new CustomerException("文章不存在");
		}
		
		
	}

	@Override
	public List<ArticlePreview> preview() {
		
		return articleExtendMapper.selectAllPreview();
	}

	@Override
	public void saveOrUpdate(Article article) {
		if(article.getId() != null) {
			articleMapper.updateByPrimaryKey(article);
		}else {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size() > 0) {
				throw new CustomerException("文章标题重复");
			}
			
			article.setThumpUp(0L);
			article.setThumpDown(0L);
			article.setPublishTime(new Date().getTime());
			article.setStatus("1");
			article.setReadTimes(0L);
			articleMapper.insert(article);
			
		}
		
		
	}

	@Override
	public void check(long articleId, String status) throws CustomerException {
		if(articleMapper.selectByPrimaryKey(articleId) != null) {
			Article article = articleMapper.selectByPrimaryKey(articleId);
			
			article.setStatus(status);
			articleMapper.insert(article);
			
		}else {
			throw new CustomerException("文章不存在");
		}
		
	}

}
