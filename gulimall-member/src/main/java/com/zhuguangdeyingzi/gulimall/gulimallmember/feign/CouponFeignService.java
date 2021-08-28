package com.zhuguangdeyingzi.gulimall.gulimallmember.feign;

import com.zhuguangdeyingzi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lijun
 * @description: 调用远程服务接口
 * @date: 2021/8/25 17:19
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("gulimallcoupon/coupon/member/list")
    public R membercoupons();
}
