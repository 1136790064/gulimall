package com.zhuguangdeyingzi.gulimall.gulimallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.Query;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.dao.BrandDao;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.BrandEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    /**
     * @param params Map集合封装前端传进来的数据
     * @return com.zhuguangdeyingzi.common.utils.PageUtils 返回经过分页工具处理过的数据
     * @author 86138
     * @date 2021/9/15 9:01
     * @description: 如果有关键字根据关键字进行模糊查询，如果没有则查询全部
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //1、获取key
        String key = (String) params.get("key");
        //MyBatisPlus封装的sql查询对象
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            //拼装查询语句
            queryWrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}