package org.chp.sboot.mq.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeff
 * <p>Date: 2019-11-13 22:58:00</p>
 */
@Data
public class LogMessage implements Serializable {

    private String id;
    private String title;
    private String content;

    private Date createDate;
}
