package com.suifeng.master.service.serviceImpl;

import com.suifeng.master.dao.SysUserMapper;
import com.suifeng.master.entity.SysUser;
import com.suifeng.master.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表实现类
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<SysUser> queryList() {
        return sysUserMapper.select(null);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUserMapper.delete(sysUser);
    }
}
