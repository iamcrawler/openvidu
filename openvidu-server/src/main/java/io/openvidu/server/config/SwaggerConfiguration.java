package io.openvidu.server.config;

//import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther liuliang
 * @date 2020/7/5 7:04 PM
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
//@EnableSwaggerBootstrapUi
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean(value = "userApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.openvidu.server.rest"))
                .paths(PathSelectors.any())

                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("vhub  接口说明 文档")
                .description("<div style='font-size:14px;color:red;'>vhub接口说明</div>")
                .termsOfServiceUrl("https://moos.wiki")
                .contact("iamcrawler@sina.com")
                .version("1.0")
                .build();
    }


}