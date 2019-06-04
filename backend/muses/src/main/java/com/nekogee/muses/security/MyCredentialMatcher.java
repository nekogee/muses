package com.nekogee.muses.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

public class MyCredentialMatcher extends CodecSupport implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        Object tokenCredential = token.getCredentials();
        System.out.println("token.credentials "+ tokenCredential);
        Object accountCredential = info.getCredentials();
        System.out.println("info.credentials "+ accountCredential);
        if (info instanceof SaltedAuthenticationInfo) {
            ByteSource salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
            String encrypt = new String(salt.getBytes());
            /*String md51 = new Md5Hash(tokenCredential, ((SaltedAuthenticationInfo) info).getCredentialsSalt(), 200).toHex();
            String s2 = md51 + encrypt;
            String md52 = new Md5Hash(s2).toString();*/
            String encryptpwd = new Md5Hash(tokenCredential, salt, 200).toBase64();
            return encryptpwd.equals(accountCredential);
        }
        return false;
    }
}
