package com.zhuguangdeyingzi.gulimall.gulimallcoupon.dao;

import com.zhuguangdeyingzi.gulimall.gulimallcoupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-25 09:27:09
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
