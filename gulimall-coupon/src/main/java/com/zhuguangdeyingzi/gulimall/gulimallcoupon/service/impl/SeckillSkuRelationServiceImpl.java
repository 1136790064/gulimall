package com.zhuguangdeyingzi.gulimall.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.Query;

import com.zhuguangdeyingzi.gulimall.gulimallcoupon.dao.SeckillSkuRelationDao;
import com.zhuguangdeyingzi.gulimall.gulimallcoupon.entity.SeckillSkuRelationEntity;
import com.zhuguangdeyingzi.gulimall.gulimallcoupon.service.SeckillSkuRelationService;


@Service("seckillSkuRelationService")
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationDao, SeckillSkuRelationEntity> implements SeckillSkuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuRelationEntity> page = this.page(
                new Query<SeckillSkuRelationEntity>().getPage(params),
                new QueryWrapper<SeckillSkuRelationEntity>()
        );

        return new PageUtils(page);
    }

}