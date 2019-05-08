package com.gangbin.store.bean;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
    private Integer bookId;

    private String author;

    private String title;

    private Float price;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date publishingDate;

    private Integer salesAmount;

    private Integer storeNumber;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", author=" + author + ", title=" + title + ", price=" + price
				+ ", publishingDate=" + publishingDate + ", salesAmount=" + salesAmount + ", storeNumber=" + storeNumber
				+ "]";
	}
    
}