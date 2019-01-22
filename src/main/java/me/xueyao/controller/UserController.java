package me.xueyao.controller;

import me.xueyao.common.BaseEnum;
import me.xueyao.common.BaseResponse;
import me.xueyao.model.entity.User;
import me.xueyao.model.request.UserRequest;
import me.xueyao.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/21 15:44
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public BaseResponse addUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userService.addUser(user);
    }

    @PutMapping("/modifyUser")
    public BaseResponse modifyUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest,  user);
        return userService.modifyUser(user);
    }

    @DeleteMapping("/removeUser/{userId}")
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
    public BaseResponse getUser(@PathVariable("userId") int userId) {
        BaseResponse baseResponse = new BaseResponse();
        if (1 > userId) {
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("非法参数，请重试");
            return baseResponse;
        }
        return userService.getUser(userId);
    }



}
