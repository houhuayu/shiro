package com.github.zhangkaitao.shiro.chapter2.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

public class MyRealm5 implements Realm{

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return false;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
