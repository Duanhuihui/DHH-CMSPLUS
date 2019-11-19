package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.CommentExample;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.dao.CommentMapper;
import com.briup.apps.cms.service.ICommentService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class CommentServiceImpl implements ICommentService{
	@Resource
	private CommentMapper commentMapper;

	@Override
	public Comment add(Comment comment) {
		if(commentMapper.selectByPrimaryKey(comment.getId() ) == null) {
			Comment comm = new Comment();
			comm.setArticleId(comment.getArticleId());
			comm.setCommentTime(new Date().getTime());
			comm.setContent(comment.getContent());
			comm.setStatus(CommentExtend.UNCHECK);
			comm.setUserId(comment.getUserId());
			commentMapper.insert(comm);
			return comm;
		}else {
			
			throw new CustomerException("出错了");
		}
	}

	@Override
	public Comment replay(Comment comment,long parentId) {
		Comment comm = new Comment();
		if(parentId > 0) {
			
			comm.setArticleId(comment.getArticleId());
			comm.setContent(comment.getContent());
			comm.setUserId(comment.getUserId());
			comm.setStatus(CommentExtend.UNCHECK);
			comm.setCommentTime(new Date().getTime());
			comm.setParentId(parentId);
			commentMapper.insert(comm);
			return comm;
		}else {
			throw new CustomerException("出错了");
		}
		
		
	}

	@Override
	public void remove(long commentId) {
		if(commentMapper.selectByPrimaryKey(commentId) != null) {
			
			commentMapper.deleteByPrimaryKey(commentId);
			
		}else {
			throw new CustomerException("出错了");
		}
		
	}

	@Override
	public Comment check(long commentId, String status) {
		Comment comment = commentMapper.selectByPrimaryKey(commentId);

		if (comment != null) {
			comment.setStatus(status);
			commentMapper.updateByPrimaryKey(comment);
			return commentMapper.selectByPrimaryKey(comment.getId());
		} else {
			throw new CustomerException("出错了");
		}

	}

	@Override
	public List<Comment> findAll(long articleId) {
		CommentExample example = new CommentExample();
		example.createCriteria().andArticleIdEqualTo(articleId);
		List<Comment> list = commentMapper.selectByExample(example);
		return list;
	}

}
