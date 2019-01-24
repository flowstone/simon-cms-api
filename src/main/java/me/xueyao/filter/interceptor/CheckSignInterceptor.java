package me.xueyao.filter.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/24 17:18
 */
@Component
public class CheckSignInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(CheckSignInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String currentTimestamp = request.getHeader("current-timestamp");
        String nonceStr = request.getHeader("nonce-str");
        String simonCmsSign = request.getHeader("simon-cms-sign");
        logger.info("token = {}, current-timestamp = {}, nonce-str = {}, simon-cms-sign = {}",
                token, currentTimestamp, nonceStr, simonCmsSign);

        if (StringUtils.isEmpty(currentTimestamp)
                || currentTimestamp.length() != 13
                || StringUtils.isEmpty(nonceStr)
                || nonceStr.length() < 16
                || StringUtils.isEmpty(simonCmsSign)) {
            logger.error("没有接口权限");

        }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
