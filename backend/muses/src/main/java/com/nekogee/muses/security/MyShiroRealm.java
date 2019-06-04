package com.nekogee.muses.security;

import com.nekogee.muses.entity.SysPermission;
import com.nekogee.muses.entity.SysRole;
import com.nekogee.muses.entity.SysUser;
import com.nekogee.muses.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserService sysUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser  = (SysUser)principals.getPrimaryPrincipal();
        for(SysRole role:sysUser.getSysRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getSysPermissionList()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authctoken)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken token = (UsernamePasswordToken) authctoken;
        token.setRememberMe(true);
        //获取用户的输入的账号.

        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials()+"   username: "+username+" ");
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //SysUser sysUser = userRepository.findUserByUsername(username);
        SysUser sysUser = sysUserService.findUserByUsername(username);
        System.out.println("----->>userInfo="+sysUser.getAlias());
        System.out.println("----->>password="+sysUser.getPassword());
        System.out.println("----->>salt="+sysUser.getCredentialsSalt());
        if(sysUser == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser, //principal
                sysUser.getPassword(), //hashedCredentials
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),//credentialsSalt
                getName()  //realmName
        );

        return authenticationInfo;
    }

    @PostConstruct
    public void initCredentialsMatcher() {
        CredentialsMatcher matcher = new MyCredentialMatcher();
        setCredentialsMatcher(matcher);
    }
}
