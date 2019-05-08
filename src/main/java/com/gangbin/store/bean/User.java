package com.gangbin.store.bean;

public class User {
    private Integer userId;

    private String userName;

    private Integer accountId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", accountId=" + accountId + "]";
	}
    
}