package com.suifeng.master.dao;

import com.suifeng.master.entity.SysMenu;
import com.suifeng.master.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SysRoleMenuMapper extends com.github.abel533.mapper.Mapper<SysRoleMenu> {
    /**
     * 根据角色id查询菜单id
     * @param roleId
     * @return
     */
    List<Integer> queryMenuIdByRoleId(Integer roleId);

}
