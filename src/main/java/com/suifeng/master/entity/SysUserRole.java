package com.suifeng.master.entity;


import java.io.Serializable;

/**
 * 用户-角色表实体类
 */
public class SysUserRole implements Serializable {
    private Integer id;//主键
    private Integer userId;//'用户ID',
    private Integer roleId;//'角色ID',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
