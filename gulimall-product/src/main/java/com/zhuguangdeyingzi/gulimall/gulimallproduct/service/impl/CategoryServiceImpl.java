package com.zhuguangdeyingzi.gulimall.gulimallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuguangdeyingzi.common.utils.PageUtils;
import com.zhuguangdeyingzi.common.utils.Query;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.dao.CategoryDao;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryEntity;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类 baseMapper通过泛型实现，这里表示的就是CategoryDao的注入
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2、组装成父子的树形结构
        //2.1、找到所有的一级分类 stream(),将调用此方法的对象转换为流、filter()依据条件对流进行筛选，条件为ture的保留
        return entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu) -> {
            //将每个菜单的所有子菜单映射到自身的Childrens属性中
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            //menu1：前一个菜单，menu2：后一个菜单，通过Sort字段进行排序
            return menu1.getSort() - menu2.getSort();
            //collect(Collectors.toList())收集数据并返回一个List集合
        }).collect(Collectors.toList());
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前删除的菜单，是否被别的地方引用
        //逻辑删除
        
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * @param root 指定菜单
     * @param all  所有菜单信息，以List集合传进来
     * @return java.util.List<com.zhuguangdeyingzi.gulimall.gulimallproduct.entity.CategoryEntity>
     * @author 86138
     * @date 2021/8/28 15:51
     * @description: 在所有菜单中找到指定菜单的所有子菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        //递归查找所有菜单的子菜单
        return all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //2、菜单的排序
            return menu1.getSort() - menu2.getSort();
        }).collect(Collectors.toList());
    }
}