package com.eric.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author shanbb
 * @description
 * @date 2019-08-24
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String brief;
    private Date birthday;
}
