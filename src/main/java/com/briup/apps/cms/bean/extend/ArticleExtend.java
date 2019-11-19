package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

public class ArticleExtend extends Article{
	public static final  String CHECKED = "已审核";
	public static final  String UNCHECKED = "未审核";
	public static final  String UNPASS = "未通过";
	public static final  String ILLEGAL = "非法文章";
	
	private Category category;
	
	private List<Comment> comments;
	
	private User user;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
