package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.service.ICommentService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestController
@RequestMapping("comment")
public class CommentController {
	@Resource
	private ICommentService iCommentService;
	
	@PostMapping("add")
	public Message add(Comment comment) {
		Comment add = iCommentService.add(comment);
		return MessageUtil.success("评论成功",add);
	}
	@PostMapping("replay")
	public Message replay(Comment comment,long parentId) {
		Comment message = iCommentService.replay(comment,parentId);
		return MessageUtil.success("回复成功",message);
	}
	@PostMapping("remove")
	public Message remove(long commentId) {
		 iCommentService.remove(commentId);
		return MessageUtil.success("删除成功");
	}
	@PostMapping("check")
	public Message check(long commentid,String status) {
		Comment checked = iCommentService.check(commentid,status);
		return MessageUtil.success("审核完毕",checked);
	}
	@PostMapping("findAll")
	public Message findAll(long articleId) {
		List<Comment> list = iCommentService.findAll(articleId);
		return MessageUtil.success("查找完成",list);
	}

}
