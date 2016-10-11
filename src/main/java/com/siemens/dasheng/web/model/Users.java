package com.siemens.dasheng.web.model;

/**
 * yaming.chen@siemens.com
 * Created by chenyaming on 2016/10/11.
 */
public class Users extends BaseEntity {

    private String username;
    private String passwd;
    private int usertype;       //用户类型：0（超级用户）；1（管理员用户）；2（普通用户）
    private int deleted;        //是否逻辑删除：0否；1是
    private String realname;
    private String obligate01;  //预留字段01
    private String obligate02;
    private String obligate03;


    @Override
    public String toString() {
        return "Users{" +
                "id='" + super.getId() + '\'' +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", usertype=" + usertype +
                ", deleted=" + deleted +
                ", realname='" + realname + '\'' +
                ", obligate01='" + obligate01 + '\'' +
                ", obligate02='" + obligate02 + '\'' +
                ", obligate03='" + obligate03 + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getObligate01() {
        return obligate01;
    }

    public void setObligate01(String obligate01) {
        this.obligate01 = obligate01;
    }

    public String getObligate02() {
        return obligate02;
    }

    public void setObligate02(String obligate02) {
        this.obligate02 = obligate02;
    }

    public String getObligate03() {
        return obligate03;
    }

    public void setObligate03(String obligate03) {
        this.obligate03 = obligate03;
    }
}
