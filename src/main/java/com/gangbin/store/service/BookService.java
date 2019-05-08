package com.gangbin.store.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gangbin.store.bean.Book;
import com.gangbin.store.bean.BookExample;
import com.gangbin.store.dao.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;

	public List<Book> getAll() {
		// TODO Auto-generated method stub
		 return bookMapper.selectByExample(null);
	}

	public boolean checkUser(String title) {
		BookExample bookExample=new BookExample();
		bookExample.createCriteria().andTitleEqualTo(title);
		List<Book> list=bookMapper.selectByExample(bookExample);
		return list.size()==0;
	}
	
	 

}
