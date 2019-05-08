package com.gangbin.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//���������
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
		String regx = "(^[a-zA-Z0-9_-]{1,32}$)|(^[\u2E80-\u9FFF]{1,16})";
		if(!title.matches(regx)){
			return Message.fail().add("va_msg", "����������1-16λ���Ļ���1-32λӢ�ĺ����ֵ����");
		}
		
		boolean b = bookService.checkUser(title);
		if(b){
			return Message.success();
		}else{
			return Message.fail().add("va_msg", "�ظ�����");
		}
	}
}
