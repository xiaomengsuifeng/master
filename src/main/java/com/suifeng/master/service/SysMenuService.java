package com.suifeng.master.service;

import com.suifeng.master.entity.SysMenu;

import java.util.List;

/**
 * 菜单表接口
 */
public interface SysMenuService {
    /**
     * 查询所有菜单
     * @return
     */
    List<SysMenu> queryList();

    /**
     * 根据用户id查询所有菜单
     * @return
     */
    List<SysMenu> queryListByUserId(Integer id);

    /**
     * 根据类型查询所有菜单
     * @param type
     * @return
     */
    List<SysMenu> queryMenuByType(Integer type);
}
