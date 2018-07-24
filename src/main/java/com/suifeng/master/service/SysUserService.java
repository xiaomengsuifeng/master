package com.suifeng.master.service;

import com.suifeng.master.entity.SysUser;

import java.util.List;

/**
 * 用户表接口
 */
public interface SysUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> queryList();

    /**
     * 根据用户id删除用户
     * @param id
     */
    void deleteUserById(Integer id);
}
