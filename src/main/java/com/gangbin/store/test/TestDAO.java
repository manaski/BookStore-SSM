package com.gangbin.store.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gangbin.store.dao.BookMapper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:springmvc.xml" })
public class TestDAO {
	
	@Autowired
	BookMapper bookMapper;
	
	//web上下文对象
	@Autowired
	WebApplicationContext context;
	
	//模拟请求
	MockMvc mockMvc;
	
	//初始化
	@Before
	public void initMokcMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void test() throws Exception{
		  
		 MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/books"))
					.andReturn();
          MockHttpServletRequest request = result.getRequest();
	      PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
	      System.out.println("当前页数"+pi.getPageNum());
		  System.out.println("总页数"+pi.getPages());
		  System.out.println("总记录数"+pi.getTotal());
		  System.out.println("是否有前一页"+pi.isHasPreviousPage());
		  System.out.println("是否有后一页"+pi.isHasNextPage());
	}
	
	
	

}
