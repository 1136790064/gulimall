package com.zhuguangdeyingzi.gulimall.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.BrandEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryBrandRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021/9/15 14:29
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

	void updateBrand(Long brandId, String name);

	void updateCategory(Long catId, String name);

	List<BrandEntity> getBrandsByCatId(Long catId);
}

