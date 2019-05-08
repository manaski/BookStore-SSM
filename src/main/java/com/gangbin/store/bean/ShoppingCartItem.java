package com.gangbin.store.bean;

public class ShoppingCartItem {
    private Integer itemId;

    private Integer cartId;

    private Integer bookId;

    private Integer quantity;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "ShoppingCartItem [itemId=" + itemId + ", cartId=" + cartId + ", bookId=" + bookId + ", quantity="
				+ quantity + "]";
	}
    
}