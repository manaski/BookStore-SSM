<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"   
	src="${APP_PATH }/static/jquery/jquery.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>WELCOME!</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="books_table">
				<thead>
					<tr>
					    <th>
						<input type="checkbox" id="check_all"/>
						</th>
						<th>#</th>
						<th>title</th>
						<th>author</th>
						<th>price</th>
						<th>publishingDate</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<!-- 内容由后面的Ajax进行填充 -->
					</tbody>
				</table>
			</div>
		</div>
   
		<!-- 显示分页信息 -->   <!-- 内容由后面的Ajax进行填充 -->
		<div class="row" >
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
			</div>
		</div>
	</div>
	
	<!-- 卸载script标签中，JS的代码 -->
	<script type="text/javascript">
	var totalRecord,currentPage;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function(){
		//去首页
		to_page(1);
	});
	
	function to_page(pn){
		$.ajax({
			url:"${APP_PATH}/books",
			data:"pn="+pn,
			type:"GET",
			success:function(result){
		   // console.log(result);
				//1、解析并显示书籍数据
				build_books_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
			}
		});
	}
	function build_books_table(result){
		//清空table表格，每次都清空表格里面的内容,重新填充
		$("#books_table tbody").empty();
		var emps = result.extend.pageInfo.list;
		alert(result);
		
	}
	
	</script>

</body>
</html>