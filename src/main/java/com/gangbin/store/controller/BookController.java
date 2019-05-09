package com.gangbin.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gangbin.store.bean.Book;
import com.gangbin.store.bean.Message;
import com.gangbin.store.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	//测试用这个
	//@RequestMapping("/books")
	public String getAll(@RequestParam(value="pn",defaultValue="1") Integer pn, Model model){
		PageHelper.startPage(pn, 3);
		List<Book> list=bookService.getAll();
		PageInfo pageInfo=new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		return  "list";
	}
	
	@RequestMapping("/books")
	@ResponseBody
	public Message getAll2(@RequestParam(value="pn",defaultValue="1") Integer pn){
		PageHelper.startPage(pn, 3);
		List<Book> list=bookService.getAll();
		PageInfo pageInfo=new PageInfo(list);
		Message message=Message.success().add("pageInfo", pageInfo);
		return  message;
	}
	
	@ResponseBody
	@RequestMapping("/checktitle")
	public Message checkuser(@RequestParam("title")String title){
		System.out.println("checkTitle");
		String regx = "(^[a-zA-Z0-9_-]{1,32}$)|(^[\u2E80-\u9FFF]{1,16})";
		if(!title.matches(regx)){
			return Message.fail().add("va_msg", "书名可以是1-16位中文或者1-32位英文和数字的组合");
		}
		
		boolean b = bookService.checkUser(title);
		System.out.println(b);
		if(b){
			return Message.success();
		}else{
			return Message.fail().add("va_msg", "重复书名");
		}
	}
	
	@ResponseBody
	@RequestMapping("/savebook")
	public Message saveBook(@Valid Book book,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("校验不通过的字段----"+fieldError.getField());
				System.out.println("错误信息----"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), "格式不正确");
			}
			return Message.fail().add("errorFields", map);
		}else{
			bookService.saveBook(book);
			return Message.success();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/bookToEdit/{id}",method=RequestMethod.GET)
	public Message bookToEdit(@PathVariable("id") Integer id){
		System.out.println("收到了请求");
		Book book=bookService.getBook(id);
		System.out.println(book);
		return Message.success().add("book", book);
	}
	
	//springmvc 自动包装类型参数
	@ResponseBody
	@RequestMapping(value="/updateBook/{bookId}", method=RequestMethod.PUT)
	public Message updateBook(@Valid Book book,BindingResult result,HttpServletRequest request){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("校验不通过的字段----"+fieldError.getField());
				System.out.println("错误信息----"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), "格式不正确");
			}
			return Message.fail().add("errorFields", map);
		}else{
			System.out.println("请求域中含有参数"+request.getParameter("price"));
			System.out.println("更新  "+book);
			bookService.updateBook(book);
			System.out.println(bookService.getBook(book.getBookId()));
			return Message.success();
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	public Message deleteBook(@PathVariable("id") String ids){
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			bookService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			bookService.deleteBook(id);
		}
		return Message.success();
	}

}
