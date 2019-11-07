package org.chp.sboot.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.chp.sboot.mybatis.domain.User;

/**
 *  继承 BaseMapper<>可实现简单的CRUD功能
 *  复杂功能需要自定义的Mapper映射文件
 * @author jeff
 * <p>Date: 2019-11-06 18:30:00</p>
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findById(Integer id);
}
