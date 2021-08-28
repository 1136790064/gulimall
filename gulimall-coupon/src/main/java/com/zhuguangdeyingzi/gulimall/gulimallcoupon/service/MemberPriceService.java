package com.zhuguangdeyingzi.gulimall.gulimallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.gulimall.gulimallcoupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-25 09:27:08
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

