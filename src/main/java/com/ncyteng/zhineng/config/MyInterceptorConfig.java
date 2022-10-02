package com.ncyteng.zhineng.config;


import com.ncyteng.zhineng.tools.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
//设置路径然后经过这个路径的都到MyInterceptor类中
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public MyInterceptor text(){
        return new MyInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        addInterceptor将定义的拦截器配置放好 addPathPatterns将定义的路径放好
//        所有的路径都设置拦截器 jwt验证只适合前后端分离，现在还是需要session
//        将所有的项目设置好之后在设置拦截器 在前面加入admin
        registry.addInterceptor(text()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login","/admin/check", "/swagger-ui.html/**");
        super.addInterceptors(registry);
    }

    //防止拦截静态资源
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        类似tomcat的deployment  所有/image下面的文件 都去d盘项目里面的image里面找
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:D:/java/project/zhineng/image/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

//        ueditor上传文件设置路径
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:D:/java/project/zhineng/image/");

//        防止swagger被拦截
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");


        super.addResourceHandlers(registry);
    }
}
