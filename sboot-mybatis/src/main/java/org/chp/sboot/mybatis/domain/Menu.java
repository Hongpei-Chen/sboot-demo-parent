package org.chp.sboot.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jeff
 * <p>Date: 2020-01-02 17:59:00</p>
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 6695174611269270969L;

    private String id;

    private String menuName;

    private String pid;

    private Boolean hidden;
}
