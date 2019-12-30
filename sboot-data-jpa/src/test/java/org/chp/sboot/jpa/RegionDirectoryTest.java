package org.chp.sboot.jpa;

import cn.hutool.json.JSONUtil;
import org.chp.sboot.jpa.domain.RegionDirectory;
import org.chp.sboot.jpa.domain.RegionDirectoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jeff
 * <p>Date: 2019-11-27 09:55:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionDirectoryTest {

    @Autowired
    private RegionDirectoryRepository regionDirectoryRepository;


    @Test
    public void testFindByPid(){
        List<RegionDirectory> regionDirectorys = regionDirectoryRepository.findByPid(440000);
        System.out.println(JSONUtil.toJsonStr(regionDirectorys));
    }
}
