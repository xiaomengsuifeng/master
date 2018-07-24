package com.suifeng.master.controller;

import com.suifeng.master.entity.SysMenu;
import com.suifeng.master.entity.SysUser;
import com.suifeng.master.service.SysMenuService;
import com.suifeng.master.service.SysUserService;
import com.suifeng.master.utils.R;
import com.suifeng.master.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录controller
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    //退出的时候是get请求，主要是用于退出
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //post登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R login(SysUser sysUser , String vercode){

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        //获取session中验证码
        String vrifyCode = (String) subject.getSession().getAttribute("vrifyCode");
        if (!vrifyCode.equalsIgnoreCase(vercode)){
            //不相同验证码错误返回信息
            return R.error("验证码错误");
            //return R.ok().put("msg","验证码错误");
        }
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                    sysUser.getSysName(),
                    sysUser.getSysPassword());
            subject.login(usernamePasswordToken);
            SysUser userEntity = ShiroUtils.getUserEntity();
            //设置密码为空
            userEntity.setSysPassword(null);
            return R.ok().put("user",userEntity).put("msg","登录成功");
            //进行验证，这里可以捕获异常，然后返回对应信息
        }catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        }catch (LockedAccountException e) {
            return R.error(e.getMessage());
        }catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public R logout(){
        ShiroUtils.logout();
        return R.ok();
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }

    //数据初始化
    /*@RequestMapping(value = "/addUser")
    public String addUser(@RequestBody Map<String,Object> map){
        User user = loginService.addUser(map);
        return "addUser is ok! \n" + user;
    }*/

    //角色初始化
    /*@RequestMapping(value = "/addRole")
    public String addRole(@RequestBody Map<String,Object> map){
        Role role = loginService.addRole(map);
        return "addRole is ok! \n" + role;
    }*/

    //注解的使用
    /*@RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }*/

    /**
     * 获取当前用户的菜单项
     * @return
     */
    @RequestMapping("/menu")
    public R queryMenu(){
        //获取当前用户信息
        SysUser userEntity = ShiroUtils.getUserEntity();
        //查询该用户管理的菜单
        List<SysMenu> sysMenuList = sysMenuService.queryListByUserId(userEntity.getId());
        return R.ok().put("menus",sysMenuList);
    }
}
