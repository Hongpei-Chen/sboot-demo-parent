package org.chp.sboot.cache.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-06 14:54:00</p>
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;

    private String email;

    private String phone;

    @Column(nullable = false)
    private Date createDate;

    private Date updateDate;
}
