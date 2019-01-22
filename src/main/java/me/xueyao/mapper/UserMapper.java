package me.xueyao.mapper;

import me.xueyao.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(User record);

    int insertSelective(User record);

    Optional<User> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUser();

    /**
     * @Note: 根据用户名查询用户信息
     * @param: username 用户名
     * @return:
     * @author: Simon.Xue
     * @date: 2019/1/22 12:16
     */
    User selectByUsername(@Param("username") String username);
}