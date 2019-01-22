package me.xueyao.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @ToString
public class User {
    private Integer id;

    private String username;

    private String password;

    private Boolean delete;

    private Date createTime;

    private Date updateTime;
}