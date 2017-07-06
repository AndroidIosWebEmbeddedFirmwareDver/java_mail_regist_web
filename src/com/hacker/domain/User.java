package com.hacker.domain;


/**
 * 
 * @author wangxiaolong
 *CREATE TABLE USER(
     
    uid INT AUTO_INCREMENT PRIMARY KEY,
    
    username VARCHAR(20) DEFAULT NULL,
    
    PASSWORD VARCHAR(20) DEFAULT NULL,
    
    nickname VARCHAR(20) DEFAULT NULL,
    
    email  VARCHAR(30) DEFAULT NULL,
    
    state INT(11) DEFAULT NULL,
    
    CODE VARCHAR(64) DEFAULT NULL
    
    )
    
    ENGINE=INNODB DEFAULT CHARSET=utf8;
 */
public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private int state; // 0 未激活 1 已激活
	private String code;//64位激活码

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
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
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
