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
		 List<Book> res=bookMapper.selectByExample(null);
//		 System.out.println("�鼮������"+res.size());
//		 for(Book b:res){
//			 System.out.println(b);
//		 }
			return res;
	}

	public boolean checkUser(String title) {
		BookExample bookExample=new BookExample();
		bookExample.createCriteria().andTitleEqualTo(title);
		List<Book> list=bookMapper.selectByExample(bookExample);
		return list.size()==0;
	}

	public void saveBook(Book book) {
		bookMapper.insertSelective(book);
		
	}

	public Book getBook(Integer id) {
		return bookMapper.selectByPrimaryKey(id);
	}

	public void updateBook(Book book) {
		bookMapper.updateByPrimaryKeySelective(book);
	}
	
	public void deleteBook(Integer bookId){
		bookMapper.deleteByPrimaryKey(bookId);
	}

	public void deleteBatch(List<Integer> del_ids) {
		for(Integer i:del_ids){
			bookMapper.deleteByPrimaryKey(i);
		}
	}
	 

}
