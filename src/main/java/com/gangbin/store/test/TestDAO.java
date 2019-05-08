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
	
	//web�����Ķ���
	@Autowired
	WebApplicationContext context;
	
	//ģ������
	MockMvc mockMvc;
	
	//��ʼ��
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
	      System.out.println("��ǰҳ��"+pi.getPageNum());
		  System.out.println("��ҳ��"+pi.getPages());
		  System.out.println("�ܼ�¼��"+pi.getTotal());
		  System.out.println("�Ƿ���ǰһҳ"+pi.isHasPreviousPage());
		  System.out.println("�Ƿ��к�һҳ"+pi.isHasNextPage());
	}
	
	
	

}
