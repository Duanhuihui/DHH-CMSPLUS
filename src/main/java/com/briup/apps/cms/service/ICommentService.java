package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.utils.CustomerException;

public interface ICommentService {
	//添加评论，新建一个评论，在返回新建的评论，异步返回
	Comment add(Comment comment)throws CustomerException;
	//回复评论
	Comment replay(Comment comment,long parentId);
	//删除评论
	void remove(long commentId)throws CustomerException;
	//审核评论
	Comment check(long commentId,String status)throws CustomerException;
	//展示所有评论
	List<Comment> findAll(long articleId);

	

}
