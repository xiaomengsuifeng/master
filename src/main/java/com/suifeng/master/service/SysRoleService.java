package com.suifeng.master.service;


import com.suifeng.master.entity.SysRole;

import java.util.List;

/**
 * 角色表接口
 */
public interface SysRoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<SysRole> queryList();
}
