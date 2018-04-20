package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class ShiroTest {
	
	/**
	 * 
	* @Description: 常规使用用户名密码登录（配置文件） 
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void testHelloWorld(){
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("登录异常");
		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	
	/**
	 * 
	* @Title: testMyRealm  
	* @Description: 常规使用用户名密码登录（Realm) 
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void testMyRealm(){
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("登录异常");
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	
	@Test
	public void testRealmMulti(){
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("登录异常");
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
}
