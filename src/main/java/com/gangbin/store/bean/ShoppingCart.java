package com.gangbin.store.bean;

public class ShoppingCart {
    private Integer cartId;

    private Integer userId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", userId=" + userId + "]";
	}
    
}