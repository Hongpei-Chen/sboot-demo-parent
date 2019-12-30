package org.chp.sboot.mongodb.domian;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-06 14:54:00</p>
 */
@Data
@Document(collation = "user")
public class User implements Serializable {

    @Id
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String email;

    private String phone;

    private Date createDate;

    private Date updateDate;
}
