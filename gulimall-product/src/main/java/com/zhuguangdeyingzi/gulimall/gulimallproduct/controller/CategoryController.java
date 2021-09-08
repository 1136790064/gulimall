package com.zhuguangdeyingzi.gulimall.gulimallproduct.controller;

import com.zhuguangdeyingzi.common.utils.R;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 商品三级分类
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021-08-24 16:20:16
 */
@RestController
@RequestMapping("gulimallproduct/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entities= categoryService.listWithTree();

        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("gulimallproduct:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("gulimallproduct:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改排序
     */
    @RequestMapping("/update/sort")
//    @RequiresPermissions("gulimallproduct:category:update")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("gulimallproduct:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody: 获取请求体，必须发送POST请求
     * SpringMVC自动将请求体的数据(json),转为对应的对象
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("gulimallproduct:category:delete")
    public R delete(@RequestBody Long[] catIds){
        //1、检查当前删除的菜单，是否被别的地方引用
//		categoryService.removeByIds(Arrays.asList(catIds));

		categoryService.removeMenuByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
