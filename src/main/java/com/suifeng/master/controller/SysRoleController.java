package com.suifeng.master.controller;

import com.suifeng.master.entity.SysRole;
import com.suifeng.master.entity.SysUser;
import com.suifeng.master.service.SysRoleService;
import com.suifeng.master.service.SysUserService;
import com.suifeng.master.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 角色表controller
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @RequestMapping("/list")
    public R queryList(){
        //查询所有角色
        List<SysRole> sysRoleList = sysRoleService.queryList();
        return R.ok().put("data",sysRoleList);
    }

}
