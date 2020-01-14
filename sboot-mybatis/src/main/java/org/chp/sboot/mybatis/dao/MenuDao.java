package org.chp.sboot.mybatis.dao;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.chp.sboot.mybatis.domain.Menu;
import org.chp.sboot.mybatis.mapper.MenuMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author jeff
 * <p>Date: 2020-01-02 18:01:00</p>
 */
@AllArgsConstructor
@Repository
public class MenuDao {

    private final MenuMapper menuMapper;

    public List<Menu> findAll(String menuName, Boolean hidden) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(menuName)) {
            queryWrapper.like("menu_name", menuName);
        }

        if (Objects.nonNull(hidden)) {
            queryWrapper.eq("hidden", false);
        }

        return menuMapper.selectList(queryWrapper);
    }

    public void insertMenus(List<Menu> menus) {
        menus.forEach(menu -> menuMapper.insert(menu));
    }
}
