package com.zhuguangdeyingzi.gulimall.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-24 14:59:37
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

