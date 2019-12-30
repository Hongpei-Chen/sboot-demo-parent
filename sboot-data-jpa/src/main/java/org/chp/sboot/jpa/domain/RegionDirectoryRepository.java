package org.chp.sboot.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jeff
 * <p>Date: 2019-11-27 09:54:00</p>
 */
public interface RegionDirectoryRepository extends JpaRepository<RegionDirectory, Integer> {

    List<RegionDirectory> findByPid(Integer pid);
}
