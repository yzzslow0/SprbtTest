package com.yzz.springboot.bean;


import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Tuser  implements Serializable {
  @Id
  @GeneratedValue
  private long uId;

  @Column
  private String loginName;
  @Column
  private String password;
  @Column
  private String vsername;
  @Column
  private String mobile;
  @Column
  private String email;
  @Column
  @JSONField(format="yyyy-MM-dd")
  private Date genTime;
  @Column
  @JSONField(format="yyyy-MM-dd")
  private Date loginTime;
  @Column
  @JSONField(format="yyyy-MM-dd")
  private Date lastLoginTime;
  @Column
  @JSONField(format="yyyy-MM-dd")
  private long loginCount;


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }



  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getVsername() {
    return vsername;
  }

  public void setVsername(String vsername) {
    this.vsername = vsername;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Date getGenTime() {
    return genTime;
  }

  public void setGenTime(Date genTime) {
    this.genTime = genTime;
  }


  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }


  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public long getLoginCount() {
    return loginCount;
  }

  public void setLoginCount(long loginCount) {
    this.loginCount = loginCount;
  }

}
