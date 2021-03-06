package me.xueyao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.xueyao.common.BaseEnum;
import me.xueyao.common.BaseResponse;
import me.xueyao.config.ValidationConfig;
import me.xueyao.model.entity.User;
import me.xueyao.model.request.UserRequest;
import me.xueyao.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.Set;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/21 15:44
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户API")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ValidationConfig validationConfig;
    
    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public BaseResponse addUser(@RequestBody @Valid UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userService.addUser(user);
    }



    @PutMapping("/modifyUser")
    @ApiOperation(value = "修改用户")
    public BaseResponse modifyUser(@RequestBody @Valid UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest,  user);
        return userService.modifyUser(user);
    }

    @DeleteMapping("/removeUser/{userId}")
    @ApiOperation(value = "删除用户")
    public BaseResponse removeUser(@PathVariable("userId") int userId) {
        BaseResponse baseResponse = new BaseResponse();
        if (1 > userId) {
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("非法参数，请重试");
            return baseResponse;
        }
        return userService.removeUser(userId);
    }


    @GetMapping("/getUser/{userId}")
    @ApiOperation(value = "用户查询")
    public BaseResponse getUser(@PathVariable("userId") int userId) {
        BaseResponse baseResponse = new BaseResponse();
        if (1 > userId) {
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("非法参数，请重试");
            return baseResponse;
        }
        return userService.getUser(userId);
    }

    /**
     * @Note: 验证方法
     * @param:UserRequest
     * @return:
     * @author: Simon.Xue
     * @date: 2019/1/22 15:28
     */
    @Deprecated
    public BaseResponse validationUser(UserRequest userRequest) {
        BaseResponse baseResponse = new BaseResponse(BaseEnum.BADPARAM);
        Set<ConstraintViolation<UserRequest>> validate = validationConfig.getValidator().validate(userRequest);
        for (ConstraintViolation<UserRequest> userRequestConstraintViolation : validate) {
            baseResponse.setMessage(userRequestConstraintViolation.getMessage());
        }
        return baseResponse;
    }

}
