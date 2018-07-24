package com.suifeng.master.dao;

import com.suifeng.master.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SysRoleMapper extends com.github.abel533.mapper.Mapper<SysRole> {
    /**
     * 根据角色id查询角色
     * @param role
     * @return
     */
    SysRole queryRoleByRoleId(Integer role);
}
