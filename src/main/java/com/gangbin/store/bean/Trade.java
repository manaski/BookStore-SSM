package com.gangbin.store.bean;

import java.util.Date;

public class Trade {
    private Integer tradeId;

    private Integer userId;

    private Date tradeTime;

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", userId=" + userId + ", tradeTime=" + tradeTime + "]";
	}
    
}