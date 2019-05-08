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

<!-- 添加的模态框 -->
<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">书籍添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">title</label>
		    <div class="col-sm-10">
		      <input type="text" name="title" class="form-control" id="title_add_input" placeholder="title">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">author</label>
		    <div class="col-sm-10">
		      <input type="text" name="author" class="form-control" id="author_add_input" placeholder="author" >
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">price</label>
		    <div class="col-sm-10">
			 <input type="text" name="price" class="form-control" id="price_add_input"  placeholder="price">
			      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">publishingDate</label>
		    <div class="col-sm-4">
		     <input type="text" name="publishingDate" class="form-control" id="publishingDate_add_input"  placeholder="1991-11-01" >
			      <span class="help-block"></span>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="book_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>后台管理界面</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="book_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="book_delete_all_btn">删除</button>
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
						<th>publication</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row" >
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
			</div>
		</div>
		</div>
	<script type="text/javascript">
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
				//alert("请求已发送");
		   // console.log(result);
				//1、解析并显示员工数据
				build_books_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
		     	build_page_nav(result);
			}
		});
	}
	function build_books_table(result){
		//清空table表格
		$("#books_table tbody").empty();
		//取出list对象
		var books = result.extend.pageInfo.list;
		$.each(books,function(index,item){
			//alert(item.empName);
		 	var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var bookIdTd = $("<td></td>").append(item.bookId);
			var bookTitleTd = $("<td></td>").append(item.title);
			var authorTd = $("<td></td>").append(item.author);
			var priceTd = $("<td></td>").append(item.price);
			var publicationTd = $("<td></td>").append(item.publishingDate);
		
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id",item.bookId);
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
							.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id",item.bookId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(checkBoxTd)
				.append(bookIdTd)
				.append(bookTitleTd)
				.append(authorTd)
				.append(priceTd)
				.append(publicationTd)
				.append(btnTd)
				.appendTo("#books_table tbody"); 
		});
	}
	//解析显示分页信息
	function build_page_info(result){
		$("#page_info_area").empty();
		$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
				result.extend.pageInfo.pages+"页,总"+
				result.extend.pageInfo.total+"条记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}
	//解析显示分页条，点击分页要能去下一页....
	function build_page_nav(result){
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		
		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		//当存在前一页时才会添加翻页时间，也就是发送查询请求
		if(result.extend.pageInfo.hasPreviousPage == false){
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}else{
			//为元素添加点击翻页的事件
			firstPageLi.click(function(){
				to_page(1);
			});
			prePageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum -1);
			});
		}
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		//存在下一页时才会添加点击事件，也就是查询请求
		if(result.extend.pageInfo.hasNextPage == false){
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		}else{
			nextPageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum +1);
			});
			lastPageLi.click(function(){
				to_page(result.extend.pageInfo.pages);
			});
		}
		//添加首页和前一页的提示
		ul.append(firstPageLi).append(prePageLi);
		//遍历给ul中 添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if(result.extend.pageInfo.pageNum == item){
				numLi.addClass("active");      //当前页面标亮
			}
			numLi.click(function(){
				to_page(item);
			});
			ul.append(numLi);
		});
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi);
		
		//把ul加入到nav
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}
	
	//清空表单样式及内容
	function reset_form(ele){
		$(ele)[0].reset();   //清空内容
		//清空表单样式
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	}
	
	//点击新增按钮弹出模态框。
	$("#book_add_modal_btn").click(function(){
		alert("点击");
		//清除表单数据（表单完整重置（表单的数据，表单的样式））
		reset_form("#bookAddModal form");
		//弹出模态框
		$("#bookAddModal").modal({
			backdrop:"static"
		});
	});
	
	//校验表单数据,书名可以任意不为空，只校验名字和作者，其他的由后台校验
	function validate_add_form(){
		//1、拿到要校验的数据，使用正则表达式
		var title = $("#title_add_input").val();
		var regTitle = /(^[a-zA-Z0-9_-]{1,32}$)|(^[\u2E80-\u9FFF]{1,16})/;
		if(!regName.test(title)){
			//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
			show_validate_msg("#title_add_input", "error", "书名可以是1-16位中文或者1-32位英文和数字的组合");
			return false;
		}else{
			show_validate_msg("#title_add_input", "success", "");
		};
		
		//2、校验作者信息
		var author = $("#author_add_input").val();
		var regauthor = /(^[a-zA-Z_-]{1,32}$)|(^[\u2E80-\u9FFF]{1,16})/;

		if(!regauthor.test(author)){
			//应该清空这个元素之前的样式
			show_validate_msg("#author_add_input", "error", "作者信息格式不正确");
			return false;
		}else{
			show_validate_msg("#author_add_input", "success", "");
		}
		
		/*$("#bookAddModal input").each(function(){
			if($(this).val()==""){
				show_validate_msg(this, "error", "有未填数据");
				 return false;
			}
				
		});*/
		
		return true;
	}
	//显示校验结果的提示信息
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error" == status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
	
	//校验书籍是否重复，假设title是唯一的
	$("#title_add_input").change(function(){
		//发送ajax请求校验用户名是否可用
		var title = this.value;
		$.ajax({
			url:"${APP_PATH}/checktitle",
			data:"title="+title,
			type:"POST",  
			success:function(result){
				if(result.code==100){
					show_validate_msg("#title_add_input","success","");
					$("#book_save_btn").attr("ajax-va","success");
				}else{
					show_validate_msg("#title_add_input","error",result.extend.va_msg);
					$("#book_save_btn").attr("ajax-va","error");
				}
			}
		});
	});
	
	//点击保存。
	$("#book_save_btn").click(function(){
		//1、模态框中填写的表单数据提交给服务器进行保存
		//1、先对要提交给服务器的数据进行校验
		if(!validate_add_form()){
			return false;
		};
		//1、判断之前的ajax用户名校验是否成功。如果成功。
		if($(this).attr("ajax-va")=="error"){
			return false;
		}

	});
	
	

	
	
		</script>
</body>
</html>