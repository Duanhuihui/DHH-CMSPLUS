package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface ICategoryService {

	void add(Category category);

	void update(Category category);

	void remove(long id) throws CustomerException;

	List<Category> sort(Category category);

	List<CategoryExtend> findAll();

	void saveOrUpdate(Category category)throws CustomerException;

	void batchRemove(long[] categoryIds) throws CustomerException;

}
