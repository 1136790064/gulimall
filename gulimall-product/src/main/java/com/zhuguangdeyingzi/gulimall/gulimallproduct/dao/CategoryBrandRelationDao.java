package com.zhuguangdeyingzi.gulimall.gulimallproduct.dao;

import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021/9/15 14:29
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

	void updateCategory(@Param("catId") Long catId, @Param("name") String name);
}
