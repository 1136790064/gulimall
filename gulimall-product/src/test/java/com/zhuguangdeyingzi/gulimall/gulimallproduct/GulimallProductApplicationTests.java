package com.zhuguangdeyingzi.gulimall.gulimallproduct;

//import com.aliyun.oss.OSSClient;

import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.BrandService;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息
 * 3、使用OSSClient进行相关操作
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {

    @Resource
    BrandService brandService;

    @Resource
    CategoryService categoryService;

    @Test
    public void testFindPath() {
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("完整路径:{}", Arrays.asList(catelogPath));
    }


    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("success");

//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 9));
//
//        list.forEach(System.out::println);
    }

}
