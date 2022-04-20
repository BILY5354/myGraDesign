package com.cduy.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cduy.blog.dto.CategoryBackDTO;
import com.cduy.blog.dto.CategoryDTO;
import com.cduy.blog.dto.CategoryOptionDTO;
import com.cduy.blog.entity.Category;
import com.cduy.blog.vo.CategoryVO;
import com.cduy.blog.vo.ConditionVO;
import com.cduy.blog.vo.PageResult;

import java.util.List;

/**
 * 目录服务 分类服务
 * @author CDUY
 * @version 1.0
 */
public interface CategoryService extends IService<Category> {
    /**
     * 查询分类列表
     *
     * @return 分类列表
     */
    PageResult<CategoryDTO> listCategories();

    /**
     * 查询后台分类
     *
     * @param conditionVO 条件
     * @return {@link PageResult<CategoryBackDTO>} 后台分类
     */
    PageResult<CategoryBackDTO> listBackCategories(ConditionVO conditionVO);

    /**
     * 搜索文章分类
     *
     * @param condition 条件
     * @return {@link List <CategoryOptionDTO>} 分类列表
     */
    List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO condition);

    /**
     * 删除分类
     *
     * @param categoryIdList 分类id集合
     */
    void deleteCategory(List<Integer> categoryIdList);

    /**
     * 添加或修改分类
     *
     * @param categoryVO 分类
     */
    void saveOrUpdateCategory(CategoryVO categoryVO);
}
