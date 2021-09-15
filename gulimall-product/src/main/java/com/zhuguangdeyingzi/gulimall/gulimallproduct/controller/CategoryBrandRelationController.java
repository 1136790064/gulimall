package com.zhuguangdeyingzi.gulimall.gulimallproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.R;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.BrandEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.CategoryBrandRelationService;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 品牌分类关联
 *
 * @author lijun
 * @email 1136790064lijun@gmail.com
 * @date 2021/9/15 14:29
 */
@RestController
@RequestMapping("gulimallproduct/categorybrandrelation")
public class CategoryBrandRelationController {

	@Autowired
	private CategoryBrandRelationService categoryBrandRelationService;


	@GetMapping("/brands/list")
	public R relationBrandsList(@RequestParam(value = "catId", required = true) Long catId) {
		List<BrandEntity> vos = categoryBrandRelationService.getBrandsByCatId(catId);
		List<BrandVo> collect = vos.stream().map(item -> {
			BrandVo vo = new BrandVo();
			vo.setBrandId(item.getBrandId());
			vo.setBrandName(item.getName());

			return vo;
		}).collect(Collectors.toList());

		return R.ok().put("data", collect);
	}

	/**
	 * 获取当前品牌的所有分类列表
	 */
	@GetMapping("/catelog/list")
	public R list(@RequestParam("brandId") Long brandId) {
		List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
				new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId)
		);

		return R.ok().put("data", data);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = categoryBrandRelationService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

		return R.ok().put("categoryBrandRelation", categoryBrandRelation);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
		categoryBrandRelationService.saveDetail(categoryBrandRelation);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
		categoryBrandRelationService.updateById(categoryBrandRelation);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids) {
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}
}
