package com.suifeng.master.dao;

import com.suifeng.master.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends com.github.abel533.mapper.Mapper<SysUser> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser queryByUserName(String username);

    /**
     * 根据用户id查询用户的所有权限
     * @param userId
     * @return
     */
    List<String> queryAllPerms(Integer userId);
}
