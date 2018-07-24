package com.suifeng.master.dao;

import com.suifeng.master.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysMenuMapper extends com.github.abel533.mapper.Mapper<SysMenu> {
    /**
     * 根据父菜单id查询子菜单
     * @param id
     * @return
     */
    List<SysMenu> queryListByParentId(Integer id);

    /**
     * 查询所有菜单
     * @return
     */
    List<SysMenu> selectAll();

    /**
     * 根据菜单类型查询所有菜单
     * @param type
     * @return
     */
    List<SysMenu> queryMenuByType(Integer type);
}
