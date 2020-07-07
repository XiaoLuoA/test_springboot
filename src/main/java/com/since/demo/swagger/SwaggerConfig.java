package com.since.demo.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
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

/**
 * @Author: xiaoluo
 * @Description: Swagger2的接口配置
 * @data
 * @params:
 * @return:
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {


    @Value("${config.swaggerConfig.isShow}")
    private Boolean isShow;

    @Bean
    public Docket createRoleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.since.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("Swagger测试_接口文档")
                // 描述
                .description("Swagger测试相关接口信息")
                // 作者信息
                .contact(new Contact("xiaoluo", null, "1019558287@qq.com"))
                // 版本
                .version("版本号:" + "1.0")
                .build();
    }
}