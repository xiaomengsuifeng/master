package com.suifeng.master.dao;

import com.suifeng.master.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SysUserRoleMapper extends com.github.abel533.mapper.Mapper<SysUserRole> {
    //根据用户id查询用户角色id
    List<Integer> queryRoleIdByUserId(Integer id);
}
