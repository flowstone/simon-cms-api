package me.xueyao.config;

import me.xueyao.filter.interceptor.CheckSignInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/24 17:09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private CheckSignInterceptor checkSignInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //InterceptorRegistration csi = registry.addInterceptor(checkSignInterceptor);
        //配置拦截路径
        //csi.addPathPatterns("/**");

    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/*.html");
    }
}
