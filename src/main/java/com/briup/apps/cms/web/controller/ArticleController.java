package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.ArticlePreview;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private IArticleService iArticleService;
	
	@GetMapping("findAll")
	public Message findAll(){
		List<Article> list = iArticleService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping("cascadefindAll")
	public List<ArticleExtend> cascadefindAll(){
		return iArticleService.cascadeFindAll();
	}
	
	@GetMapping("findById")
	public ArticleExtend findById(long id){
		return iArticleService.findById(id);
	}
	@PostMapping("add")
	public void add(Article article) {
		iArticleService.add(article);
	}
	@PostMapping("update")
	public void update(Article article) {
		iArticleService.update(article);
	}
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Article article) {
		iArticleService.saveOrUpdate(article);
		return MessageUtil.success("更新成功");
		
	}
	@ApiOperation("通过文章ID删除")
	@ApiImplicitParams(
			@ApiImplicitParam(name="articleId",value="编号",required=true,paramType="query")
	)
	//@DeleteMapping("remove")
	@GetMapping("remove")
	public Message remove(@RequestParam(value="articleId") Long articleId) {
		iArticleService.remove(articleId);
		return MessageUtil.success("删除成功");
	}
	@GetMapping("preview")
	public List<ArticlePreview> preview() {
		return iArticleService.preview();
	}
	@PostMapping("check")
	public Message check(long articleId,String status) {
		iArticleService.check(articleId,  status);
		return MessageUtil.success("审核成功");
	}
}
