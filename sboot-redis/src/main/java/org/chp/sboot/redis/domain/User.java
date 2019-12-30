package org.chp.sboot.redis.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-06 14:54:00</p>
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String email;

    private String phone;

    private Date createDate;

    private Date updateDate;
}
