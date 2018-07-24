package com.suifeng.master.controller;

import com.suifeng.master.entity.SysUser;
import com.suifeng.master.service.SysUserService;
import com.suifeng.master.utils.R;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表controller
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/list")
    public R queryList(){
        List<SysUser> sysUsers = sysUserService.queryList();
        return R.ok().put("data",sysUsers);
    }
    @DeleteMapping("/delete/{id}")
    @RequiresPermissions("sysUser:delete")
    public R delete(@PathVariable("id") Integer id){
            sysUserService.deleteUserById(id);

        return R.ok();
    }

    /**
     * 异常处理
     * @return
     */
    /*@ExceptionHandler(Exception.class)
    public R handleException() {
        return R.error(403,"没有权限");
    }*/
}
