package com.zhuguangdeyingzi.gulimall.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.gulimall.gulimallware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-25 10:10:05
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

