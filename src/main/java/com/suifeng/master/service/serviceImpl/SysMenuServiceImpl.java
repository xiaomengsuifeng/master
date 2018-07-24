package com.suifeng.master.service.serviceImpl;

import com.suifeng.master.dao.SysMenuMapper;
import com.suifeng.master.dao.SysRoleMenuMapper;
import com.suifeng.master.dao.SysUserRoleMapper;
import com.suifeng.master.entity.SysMenu;
import com.suifeng.master.entity.SysUserRole;
import com.suifeng.master.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单表实现类
 */
@Service("SysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    /**
     * 去除重复list(顺序不变)
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for(Iterator iter = list.iterator(); iter.hasNext();) {
            Object element =  iter.next();
            if(set.add(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<SysMenu> queryList() {
        //查询所有菜单信息
        List<SysMenu> select = sysMenuMapper.selectAll();
        return select;
    }

    /**
     *根据用户id查询菜单项
     * @return
     */
    @Override
    public List<SysMenu> queryListByUserId(Integer id) {
        //admin最高管理员
        if (id==1){
            //查询所有菜单
            List<SysMenu> select = sysMenuMapper.selectAll();
            //根据角色id查询菜单id
            List<Integer> menuIds = new ArrayList<>();
            for (SysMenu sysMenu : select) {
                menuIds.add(sysMenu.getMenuId());
            }
            //去重
            List<Integer> list = this.removeDuplicate(menuIds);
            return getAllMenuList(list);
        }else {
            //根基用户id查询用户角色
            List<Integer> roleIds = sysUserRoleMapper.queryRoleIdByUserId(id);
            //根据角色id查询菜单id
            List<Integer> menuIds = new ArrayList<>();
            for (Integer roleId : roleIds) {
                List<Integer> m = sysRoleMenuMapper.queryMenuIdByRoleId(roleId);
                menuIds.addAll(m);
            }
            //去重
            List<Integer> list = this.removeDuplicate(menuIds);

            return getAllMenuList(list);
        }
    }

    /**
     *根据菜单类型查询所有菜单
     * @param type
     * @return
     */
    @Override
    public List<SysMenu> queryMenuByType(Integer type) {
        return sysMenuMapper.queryMenuByType(type);
    }

    /**
     * 获取所有菜单列表(根据权限分配)
     */
    private List<SysMenu> getAllMenuList(List<Integer> menuIdList){
        //查询根菜单列表
        List<SysMenu> menuList = this.queryListParentId(0,menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }
    public List<SysMenu> queryListParentId(Integer parentId, List<Integer> menuIdList) {
        //查询父菜单下的所有子菜单
        List<SysMenu> menuList = sysMenuMapper.queryListByParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<>();
        for(SysMenu menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }
    /**
     * 递归获取左侧导航栏
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Integer> menuIdList){
        List<SysMenu> subMenuList = new ArrayList<SysMenu>();

        for(SysMenu entity : menuList){
            if(entity.getType() == 0){//目录
                entity.setList(getMenuTreeList(this.queryListParentId(entity.getMenuId(),menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
