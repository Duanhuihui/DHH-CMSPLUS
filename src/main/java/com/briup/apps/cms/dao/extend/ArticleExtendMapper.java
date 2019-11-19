package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.ArticlePreview;

public interface ArticleExtendMapper {
	
	List<ArticleExtend> selectAll();
	
	ArticleExtend selectById(long id);

	void insert(Article article);
	
	List<ArticlePreview> selectAllPreview();

}
