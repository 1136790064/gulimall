package com.zhuguangdeyingzi.gulimall.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryEntity;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-24 14:59:37
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    /**
     * @param catelogId 所属分类id
     * @return java.lang.Long[]
     * @author 86138
     * @date 2021/9/14 15:00
     * @description: 找到catelogId的完整路径：[父/子/孙]
     */
    Long[] findCatelogPath(Long catelogId);
}

