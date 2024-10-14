package com.mushan.common.pojo.system;

import java.util.Date;
import java.util.List;

public class SysMenu
{

/**
* 菜单ID
*/
    private Long id;
/**
* 菜单名称
*/
    private String menuName;
/**
* 父菜单ID
*/
    private Long parentId;
/**
* 显示顺序
*/
    private Integer orderNum;
/**
* 路由地址
*/
    private String path;
/**
* 组件路径
*/
    private String component;
/**
* 路由参数
*/
    private String query;


    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", query='" + query + '\'' +
                ", isFrame=" + isFrame +
                ", isCache=" + isCache +
                ", menuType='" + menuType + '\'' +
                ", visible='" + visible + '\'' +
                ", status='" + status + '\'' +
                ", perms='" + perms + '\'' +
                ", icon='" + icon + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    /**
* 是否为外链（0是 1否）
*/
    private Integer isFrame;
/**
* 是否缓存（0缓存 1不缓存）
*/
    private Integer isCache;
/**
* 菜单类型（M目录 C菜单 F按钮）
*/
    private String menuType;
/**
* 菜单状态（0显示 1隐藏）
*/
    private String visible;
/**
* 菜单状态（0正常 1停用）
*/
    private String status;
/**
* 权限标识
*/
    private String perms;
/**
* 菜单图标
*/
    private String icon;
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

    private List<SysMenu> children;

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
    }

    public String getMenuName()
    {
        return menuName;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setOrderNum(Integer orderNum)
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum()
    {
        return orderNum;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return path;
    }

    public void setComponent(String component)
    {
        this.component = component;
    }

    public String getComponent()
    {
        return component;
    }

    public void setQuery(String query)
    {
        this.query = query;
    }

    public String getQuery()
    {
        return query;
    }

    public void setIsFrame(Integer isFrame)
    {
        this.isFrame = isFrame;
    }

    public Integer getIsFrame()
    {
        return isFrame;
    }

    public void setIsCache(Integer isCache)
    {
        this.isCache = isCache;
    }

    public Integer getIsCache()
    {
        return isCache;
    }

    public void setMenuType(String menuType)
    {
        this.menuType = menuType;
    }

    public String getMenuType()
    {
        return menuType;
    }

    public void setVisible(String visible)
    {
        this.visible = visible;
    }

    public String getVisible()
    {
        return visible;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setPerms(String perms)
    {
        this.perms = perms;
    }

    public String getPerms()
    {
        return perms;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getIcon()
    {
        return icon;
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
