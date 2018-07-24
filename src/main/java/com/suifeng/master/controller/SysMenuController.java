package com.suifeng.master.controller;

import com.suifeng.master.entity.SysMenu;
import com.suifeng.master.service.SysMenuService;
import com.suifeng.master.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单表controller
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询所有菜单
     * @return
     */
    @RequestMapping("/list")
    public R queryList(){
        List<SysMenu> list = sysMenuService.queryList();
        return R.ok().put("data",list);
    }

    /**
     * 根据类型查询所有菜单
     * @param type
     * @return
     */
    @RequestMapping("/queryMenuByType/{type}")
    public R queryMenuByType(@PathVariable Integer type){
        List<SysMenu> list = sysMenuService.queryMenuByType(type);
        return R.ok().put("data",list);
    }
}
