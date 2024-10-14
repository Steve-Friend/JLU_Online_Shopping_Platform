package com.mushan.common.pojo.system;

import java.util.Date;

public class SysUser
{

/**
* 用户ID
*/
    private Long id;
/**
* 部门ID
*/
    private Long deptId;
/**
* 用户账号
*/
    private String userName;
/**
* 用户昵称
*/
    private String nickName;
/**
* 用户类型（00系统用户）
*/
    private String userType;
/**
* 用户邮箱
*/
    private String email;
/**
* 手机号码
*/
    private String phonenumber;
/**
* 用户性别（0男 1女 2未知）
*/
    private String sex;
/**
* 头像地址
*/
    private String avatar;
/**
* 密码
*/
    private String password;
/**
* 帐号状态（0正常 1停用）
*/
    private String status;
/**
* 删除标志（0代表存在 2代表删除）
*/
    private String delFlag;
/**
* 最后登录IP
*/
    private String loginIp;
/**
* 最后登录时间
*/
    private Date loginDate;
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

    private Long  role;

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
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

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate()
    {
        return loginDate;
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
