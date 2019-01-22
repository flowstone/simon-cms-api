package me.xueyao.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @ToString
public class UserResponse{
    private Integer id;

    private String username;

    private String password;

    private Boolean delete;

    private Date createTime;

    private Date updateTime;

}