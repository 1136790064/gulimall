package com.zhuguangdeyingzi.gulimall.gulimallproduct.controller;

import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.R;
import com.zhuguangdeyingzi.common.valid.AddGroup;
import com.zhuguangdeyingzi.common.valid.UpdateGroup;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.BrandEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 品牌
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-24 16:20:16
 */
@RestController
@RequestMapping("gulimallproduct/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("gulimallproduct:brand:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("gulimallproduct:brand:info")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("gulimallproduct:brand:save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand /*, BindingResult bindingResult*/) {
//
//        if (bindingResult.hasErrors()) {
//            Map<String ,String > map = new HashMap<>();
//            //1、获取校验的错误结果
//            bindingResult.getFieldErrors().forEach((item)->{
//                //FieldError 获取到错误提示
//                String message = item.getDefaultMessage();
//                //获取错误的属性名称
//                String field = item.getField();
//                map.put(field,message);
//            });
//            
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }
        brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("gulimallproduct:brand:update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand) {
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("gulimallproduct:brand:delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
