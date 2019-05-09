package com.gangbin.store.bean;

import java.sql.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
    private Integer bookId;

    private String author;

    @Pattern(regexp = "(^[a-zA-Z_-]{1,32}$)|(^[\u2E80-\u9FFF]{1,16})") 
    private String title;

    @DecimalMin("0.0")
    private Float price;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Past
    private Date publishingDate;

    @DecimalMin("0")
    private Integer salesAmount;

    @DecimalMin("0")
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