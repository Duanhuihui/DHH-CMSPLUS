package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.dao.extend.CategoryExtendMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Resource
	private CategoryMapper categoryMapper;
	
	@Resource 
	private CategoryExtendMapper categoryExtendMapper;

	@Override
	public void add(Category category) {
		categoryMapper.insert(category);
	}

	@Override
	public void update(Category category) {
		if(category != null) {
			categoryMapper.updateByPrimaryKey(category);
		}
		
	}

	@Override
	public void remove(long id) {
		
			if(categoryMapper.selectByPrimaryKey(id) != null) {
				categoryMapper.deleteByPrimaryKey(id);
			}else {
				throw new CustomerException("栏目不存在");
			}
		
		
	}

	@Override
	public List<Category> sort(Category category) {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andIdGreaterThan(1L);
		return categoryMapper.selectByExample(example);
		
	}

	@Override
	public List<CategoryExtend> findAll() {
		List<CategoryExtend> list = categoryExtendMapper.selectAll();
		return list;
	}

	@Override
	public void saveOrUpdate(Category category) {
		if(category.getId() != null) {
			categoryMapper.updateByPrimaryKey(category);
		}else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example );
			if( list.size() > 0) {
				throw new CustomerException("栏目名称已存在！");
			}else {
				categoryMapper.insert(category);
			}
		}
		
	}

	@Override
	public void batchRemove(long[] categoryIds) throws CustomerException {
		for(long categoryId:categoryIds) {
			this.remove(categoryId);
		}
		
	}

}
