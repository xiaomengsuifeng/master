package com.suifeng.master.service.serviceImpl;

import com.suifeng.master.dao.SysRoleMapper;
import com.suifeng.master.entity.SysRole;
import com.suifeng.master.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 角色表实现类
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<SysRole> queryList() {
        List<SysRole> select = sysRoleMapper.select(null);
        return select;
    }
}
