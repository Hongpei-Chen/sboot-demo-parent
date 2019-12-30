package org.chp.sboot.jpa.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jeff
 * <p>Date: 2019-11-27 09:50:00</p>
 */
@Data
@Entity
public class RegionDirectory {

    @Id
    private Integer id;

    private String name;

    private Integer pid;
}
