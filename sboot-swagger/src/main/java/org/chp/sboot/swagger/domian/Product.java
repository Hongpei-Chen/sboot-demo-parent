package org.chp.sboot.swagger.domian;

import lombok.Data;

/**
 * @author jeff
 * <p>Date: 2019-11-04 22:22:00</p>
 */
@Data
public class Product {

    private String id;
    private String productName;
    private Integer price;
    private String description;

}
