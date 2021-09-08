package com.zhuguangdeyingzi.gulimall.gulimallproduct;

//import com.aliyun.oss.OSSClient;
import com.zhuguangdeyingzi.gulimall.gulimallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息
 * 3、使用OSSClient进行相关操作
 */
@SpringBootTest
class GulimallProductApplicationTests {

    @Resource
    BrandService brandService;


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
