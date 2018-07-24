package com.suifeng.master.entity;


import java.io.Serializable;

/**
 * 角色-菜单表实体类
 */
public class SysRoleMenu implements Serializable {
    private Integer id;//主键
    private Integer roleId;//'角色ID',
    private Integer menuId;//'菜单ID',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
