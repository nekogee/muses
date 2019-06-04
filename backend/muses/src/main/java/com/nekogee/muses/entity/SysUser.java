package com.nekogee.muses.entity;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SysUser implements Serializable {

    @Id
    @GeneratedValue
    private long uid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;

    @Column(unique = true)
    private String email;

    @Column
    private String avatar;

    @Column(unique = true)
    private String phone;

    @Column
    private String bio;

    @Column
    private Byte state; // 0 -- inactive ; 1 -- normal ; 2 -- blocked

    //private int country;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> sysRoleList;

    // JPA needs a parameter-less constructor...
    public SysUser() {
    }

    public SysUser(String username, String alias, String password) {
        this.alias = alias;
        this.username = username;
        this.password = password;
    }

    public SysUser(String username, String alias, String password, String email, String avatar, String phone, String bio) {
        this.username = username;
        this.alias = alias;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.phone = phone;
        this.bio = bio;
    }

    public SysUser(String username, String alias, String password, String salt, String email, String avatar, String phone, String bio, Byte state, List<SysRole> sysRoleList) {
        this.username = username;
        this.alias = alias;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.phone = phone;
        this.bio = bio;
        this.state = state;
        this.sysRoleList = sysRoleList;
    }

    public String getCredentialsSalt(){
        return this.salt;
    }

    public void setCredentialSalt() {
        //The salt value is generated at random
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        Object salt = rng.nextBytes();
        this.salt = salt.toString();
        System.out.println("salt "+salt);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCryptPassword() {

        setCredentialSalt();

        this.setPassword(new Md5Hash(password,getCredentialsSalt(),200).toBase64());
    }

}
