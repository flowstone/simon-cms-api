package me.xueyao.service.impl;

import me.xueyao.common.BaseEnum;
import me.xueyao.common.BaseResponse;
import me.xueyao.mapper.UserMapper;
import me.xueyao.model.entity.User;
import me.xueyao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/21 15:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse addUser(User user) {
        logger.info("添加用户>>>>");
        logger.info("添加用户<<<<");
        return null;
    }

    @Override
    public BaseResponse modifyUser(User user) {
        logger.info("更新用户>>>>");
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> userInfo = userMapper.selectByPrimaryKey(user.getId());
        if (!userInfo.isPresent()) {
            logger.warn("没有该用户");
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("没有该用户");
            return baseResponse;
        }

        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (1 > updateCount) {
            logger.warn("更新用户失败，请重试");
            baseResponse.setCode(BaseEnum.BADEXCEPTION.getCode());
            baseResponse.setMessage("更新用户失败，请重试");
            return baseResponse;
        }
        baseResponse.setCode(BaseEnum.SUCCESS.getCode());
        baseResponse.setMessage("更新用户成功");
        logger.info("更新用户<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse getUser(int userId) {
        logger.info("查询用户信息>>>>");
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> user = userMapper.selectByPrimaryKey(userId);
        baseResponse.setMessage("查询用户信息成功");
        baseResponse.setCode(BaseEnum.SUCCESS.getCode());
        baseResponse.setData(user.get());
        logger.info("查询用户信息<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse listUser() {
        logger.info("查询用户列表信息>>>>");
        BaseResponse baseResponse = new BaseResponse();
        List<User> userList = userMapper.selectUser();
        baseResponse.setCode(BaseEnum.SUCCESS.getCode());
        baseResponse.setMessage("查询用户列表信息成功");
        baseResponse.setData(userList);
        logger.info("查询用户列表信息<<<<");
        return baseResponse;
    }

    @Override
    public BaseResponse removeUser(int userId) {
        logger.info("删除用户>>>>");
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> user = userMapper.selectByPrimaryKey(userId);
        if (!user.isPresent()) {
            logger.warn("该用户不存在，请重试");
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("该用户不存在，请重试");
            return baseResponse;
        }
        int deleteCount = userMapper.deleteByPrimaryKey(userId);
        if (1 > deleteCount) {
            logger.warn("删除用户失败，请重试");
            baseResponse.setCode(BaseEnum.BADPARAM.getCode());
            baseResponse.setMessage("删除用户失败，请重试");
            return baseResponse;
        }
        baseResponse.setCode(BaseEnum.SUCCESS.getCode());
        baseResponse.setMessage("删除用户成功");
        logger.info("删除用户<<<<");
        return baseResponse;
    }
}
