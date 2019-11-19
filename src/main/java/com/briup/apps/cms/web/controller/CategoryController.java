package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Resource
	private ICategoryService iCategoryService;
	
	@PostMapping("add")
	public void add(Category category) {
		iCategoryService.add(category);
	}
	@PostMapping("update")
	public void update(Category category) {
		iCategoryService.update(category);
	}
	@GetMapping("remove")
	public Message remove( @RequestParam(value="id")long id) {
		iCategoryService.remove(id);
		return MessageUtil.success("删除成功");
	}
	@PostMapping("sort")
	public List<Category> sort(Category category) {
		return iCategoryService.sort(category);
	}
	@GetMapping("findAll")
	public Message findAll() {
		List<CategoryExtend> list = iCategoryService.findAll() ;
		return MessageUtil.success("查找完成",list);
	}
	
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		iCategoryService.saveOrUpdate(category);
		return MessageUtil.success("操作成功");
	}
	@PostMapping("batchRemove")
	public Message batchRemove(@RequestBody long[] ids) {
		iCategoryService.batchRemove(ids);
		return MessageUtil.success("批量删除成功");
	}

}
