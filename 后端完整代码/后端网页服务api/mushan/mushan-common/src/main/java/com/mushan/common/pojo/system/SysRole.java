package com.mushan.common.pojo.system;

import java.util.Date;
import java.util.List;

public class SysRole
{

/**
* 角色ID
*/
    private Long id;

    public List<Long> getTreelist() {
        return treelist;
    }

    public void setTreelist(List<Long> treelist) {
        this.treelist = treelist;
    }

    /**
* 角色名称
*/
    private String roleName;
/**
* 角色权限字符串
*/
    private String roleKey;
/**
* 显示顺序
*/
    private Integer roleSort;
/**
* 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
*/
    private String dataScope;
/**
* 菜单树选择项是否关联显示
*/
    private Boolean menuCheckStrictly;
/**
* 部门树选择项是否关联显示
*/
    private Boolean deptCheckStrictly;
/**
* 角色状态（0正常 1停用）
*/
    private String status;
/**
* 删除标志（0代表存在 2代表删除）
*/
    private String delFlag;
/**
* 创建者
*/
    private String createBy;
/**
* 创建时间
*/
    private Date createTime;
/**
* 更新者
*/
    private String updateBy;
/**
* 更新时间
*/
    private Date updateTime;
/**
* 备注
*/
    private String remark;


    private List<Long> treelist;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleKey(String roleKey)
    {
        this.roleKey = roleKey;
    }

    public String getRoleKey()
    {
        return roleKey;
    }

    public void setRoleSort(Integer roleSort)
    {
        this.roleSort = roleSort;
    }

    public Integer getRoleSort()
    {
        return roleSort;
    }

    public void setDataScope(String dataScope)
    {
        this.dataScope = dataScope;
    }

    public String getDataScope()
    {
        return dataScope;
    }

    public void setMenuCheckStrictly(Boolean menuCheckStrictly)
    {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public Boolean getMenuCheckStrictly()
    {
        return menuCheckStrictly;
    }

    public void setDeptCheckStrictly(Boolean deptCheckStrictly)
    {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    public Boolean getDeptCheckStrictly()
    {
        return deptCheckStrictly;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getRemark()
    {
        return remark;
    }


}
