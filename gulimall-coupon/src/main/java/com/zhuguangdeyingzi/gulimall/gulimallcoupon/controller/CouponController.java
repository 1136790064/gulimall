package com.zhuguangdeyingzi.gulimall.gulimallcoupon.controller;

import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.R;
import com.zhuguangdeyingzi.gulimall.gulimallcoupon.entity.CouponEntity;
import com.zhuguangdeyingzi.gulimall.gulimallcoupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 优惠券信息
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-25 09:27:09
 */
@RefreshScope
@RestController
@RequestMapping("gulimallcoupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    
    @Value("${coupon.user.name}")
    private String name;
    
    @Value("${coupon.user.age}")
    private Integer age;
    
    @RequestMapping("/test")
    public R test(){
        return Objects.requireNonNull(R.ok().put("name", name)).put("age",age);
    }

    @RequestMapping("/member/list")
    public R membercoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");

        return R.ok().put("coupon", Collections.singletonList(couponEntity));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
  //@RequiresPermissions("gulimallcoupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("gulimallcoupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("gulimallcoupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("gulimallcoupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("gulimallcoupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
