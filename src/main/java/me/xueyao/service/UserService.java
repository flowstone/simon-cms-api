package me.xueyao.service;

import me.xueyao.common.BaseResponse;
import me.xueyao.model.entity.User;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/21 15:44
 */
public interface UserService {

    BaseResponse addUser(User user);

    BaseResponse modifyUser(User user);

    BaseResponse getUser(int userId);

    BaseResponse listUser();

    BaseResponse removeUser(int userId);
}
