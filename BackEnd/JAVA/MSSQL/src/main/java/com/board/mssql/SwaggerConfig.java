package com.board.mssql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ///Documentation Type -> SWAGGER2
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // apiInfo
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                // 가져올 경로 선택
                .paths(PathSelectors.any())
                .build();


        return docket;
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("컨택 이름","컨택 주소","컨택 메일");

        List<VendorExtension> vendorExtension = new ArrayList<>();

        ApiInfo apiInfo = new ApiInfo(
                "타이틀",
                "설명",
                "버전",
                "서비스 약관 주소",
                contact,
                "라이센스",
                "라이센스 주소",
                vendorExtension
                );
        return apiInfo;
    }
}
