package com.ncyteng.zhineng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
//开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.
                        basePackage("com.ncyteng.zhineng.controller"))
                .paths(PathSelectors.any())
                .build();
    }
/**
 * 当swagger打不开显示404的可能是被拦截的，在拦截控制器加一个
 */
    /**
     * 构建api文档的详细信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("标题")
                // 设置接口描述
                .description("正合智能接口文档")
                // 设置联系方式
                .contact(new Contact("史英武",
                        "http://www.ncyteng.com",
                        "2827876565@qq.com"))
                // 设置版本
                .version("1.0.5")
                // 构建
                .build();
    }
}