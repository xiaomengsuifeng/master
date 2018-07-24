package com.suifeng.master.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体类
 */
public class SysUser implements Serializable {
    private Integer id;// '主键'
    private String sysRealName;//用户昵称',
    private String sysName;//  '用户名',
    private String sysPassword;//'密码',
    private String sysEmail;//'邮箱',
    private String sysMobile;//'手机号',
    private Integer sysStatus;// '状态 0启用 1禁用',
    private Date sysCreateTime; // '创建时间',
    private Date sysUpdateTime; //'更新时间',
    private String sysRemark; // '备注',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysRealName() {
        return sysRealName;
    }

    public void setSysRealName(String sysRealName) {
        this.sysRealName = sysRealName;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysPassword() {
        return sysPassword;
    }

    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword;
    }

    public String getSysEmail() {
        return sysEmail;
    }

    public void setSysEmail(String sysEmail) {
        this.sysEmail = sysEmail;
    }

    public String getSysMobile() {
        return sysMobile;
    }

    public void setSysMobile(String sysMobile) {
        this.sysMobile = sysMobile;
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
    }

    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
}
