package com.suifeng.master.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 角色表实体类
 */
public class SysRole implements Serializable {

    private Integer roleId;//'主键id',
    private String roleName;//'角色名称',
    private String remark;//'备注',
    private Integer createUserId;//'创建者ID',
    private Date createTime; // '创建时间',
    private Date updateTime; //'更新时间',

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
