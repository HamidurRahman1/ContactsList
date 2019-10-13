package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class Login
{
	private String userName;
	private String password;
	private Boolean isActive;
	
	public Login() {}

    public Login(String userName, String password, Boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Login)) return false;
		Login login = (Login) o;
		return Objects.equals(getUserName(), login.getUserName()) &&
				Objects.equals(getPassword(), login.getPassword()) &&
				Objects.equals(isActive, login.isActive);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserName(), getPassword(), isActive);
	}

	@Override
	public String toString() {
		return "Login{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", isActive=" + isActive +
				'}';
	}
}
