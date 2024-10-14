package com.mushan.common.pojo.system;

import java.util.Date;

public class SysUserRole
{

/**
* 用户ID
*/
    private Long userId;
/**
* 角色ID
*/
    private Long roleId;
/**
* $column.columnComment
*/
    private Long id;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
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
