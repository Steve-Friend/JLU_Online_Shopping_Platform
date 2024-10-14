package com.mushan.common.pojo.system;

import java.util.Date;

public class SysRoleMenu
{

/**
* 角色ID
*/
    private Long roleId;
/**
* 菜单ID
*/
    private Long menuId;
/**
* $column.columnComment
*/
    private Long id;

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setMenuId(Long menuId)
    {
        this.menuId = menuId;
    }

    public Long getMenuId()
    {
        return menuId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }


}
