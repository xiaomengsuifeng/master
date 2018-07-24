package com.suifeng.master.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表实体类
 */
public class SysMenu implements Serializable {
    private Integer menuId; //主键id
    private Integer parentId; //'父菜单ID，一级菜单为0',
    private String name; //'菜单名称',
    private String url; //'菜单URL',
    private String perms; //'授权(多个用逗号分隔，如：user:list,user:create)',
    private Integer type; //'类型 0：目录   1：按钮',
    private String icon; //'菜单图标',
    private Integer orderNum; //'排序',
    private Integer isDelete; //'是否删除 0未删除 1删除',
    private Date updateTime; //'更新时间',
    private Date createTime; //'创建时间',

    //临时变量
    //子菜单
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
