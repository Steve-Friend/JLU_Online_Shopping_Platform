package com.mushan.dao.system;

import java.util.List;
import com.mushan.common.pojo.system.SysRoleMenu;


public interface SysRoleMenuDao
{


    public List<SysRoleMenu> list(SysRoleMenu sysRoleMenu);

    public SysRoleMenu query(Long id);

    public int add(SysRoleMenu sysRoleMenu);

    public int edit(SysRoleMenu sysRoleMenu);

    public int delete(Long id);

    List<Long> gettree(Long id);

    int deleteByRid(Long id);
}
