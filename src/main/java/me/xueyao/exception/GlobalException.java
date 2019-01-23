package me.xueyao.exception;

import me.xueyao.common.BaseEnum;
import me.xueyao.common.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局处理异常
 * @Author: Simon.Xue
 * @Date: 2019/1/23 10:13
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {

    private final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败",e.getBindingResult().getFieldError().getDefaultMessage());
        BaseResponse baseResponse = new BaseResponse(BaseEnum.BADEXCEPTION);
        baseResponse.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return baseResponse;
    }
}
