package com.zhuguangdeyingzi.gulimall.gulimallproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、整合MyBatis-Plus
 *      1)、导入依赖
 *      <dependency>
 *          <groupId>com.baomidou</groupId>
 *          <artifactId>mybatis-plus-boot-starter</artifactId>
 *          <version>3.2.0</version>
 *      </dependency>
 *      2）、配置
 *          1、配置数据源 
 *              1)、导入数据库的驱动。
 *              2)、在application.yml配置数据源相关信息
 *          2、配置MyBatis-Plus
 *              1)、使用@MapperScan
 *              2)、告诉MyBatis-Plus，sql映射文件位置
 * 2、逻辑删除
 *      1)、配置全局的逻辑删除规则(可以省略)
 *      2)、配置逻辑删除的主键(3.1.1开始可以省略)
 *      3)、实体类字段上加上@TableLogic注解
 *      
 * 3、JSR303
 *      1)、给Been添加校验注解:javax.validation.constraints，并定义自己的message提示
 *      2)、开启校验功能@Valid
 *              效果:校验错误以后会有默认的响应；
 *      3)、给校验的been后紧跟一个BindingResult，就可以获取到校验的结果
 *      4)、分组校验
 *              1)、@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *                  给校验注解标注什么情况需要进行校验
 *              2)、@Validated({AddGroup.class})
 *              3)、默认没有指定分组的校验注解@NotBlank,在分组校验情况下不生效,只会在@Validated生效;
 *      
 * 4、统一的异常处理
 * @ControllerAdvice
 *      1)、编写异常处理类，使用@ControllerAdvice
 *      2)、使用@ExceptionHandler标注方法可以处理的异常
 */
@SpringBootApplication
@MapperScan("com.zhuguangdeyingzi.gulimall.gulimallproduct.dao")
@EnableDiscoveryClient
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
