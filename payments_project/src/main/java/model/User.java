package model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String fullName;
	private String email;
	private String login;
	private String password;
	private int roleId;
	private Date registerDate;
	private boolean blocked;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getRegisterDate() {
		return (Date)registerDate.clone();
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = (Date)registerDate.clone();
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email="
				+ email + ", login=" + login + ", password=" + password
				+ ", roleId=" + roleId + ", registerDate=" + registerDate
				+ ", blocked=" + blocked + "]";
	}


}
