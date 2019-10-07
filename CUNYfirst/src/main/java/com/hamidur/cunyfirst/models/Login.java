package com.hamidur.cunyfirst.models;

import java.util.Objects;

public class Login
{
	private String userName;
	private String password;
	
	public Login() {}
	
	public Login(String userName, String password)
	{
		this.setUserName(userName);
		this.setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Login)) return false;
		Login login = (Login) o;
		return Objects.equals(getUserName(), login.getUserName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserName());
	}

	@Override
	public String toString()
	{
		return "Login{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
	}
}
