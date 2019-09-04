<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
</head>
<body>
<h1 align="center" style="font-size: 34px;">电影列表显式</h1>
<form action="list.do" method="post">
电影名称：<input type="text" name="mname" value="${mname }">
<input type="submit" value="搜索">
</form><br>
<table>
	<tr>
		<td>
			<input type="button" value="全选/全不选" id="b1">
			<input type="button" value="反选" id="b2">
		</td>
		<td>电影ID</td>
		<td>电影名称</td>
		<td>剧情介绍</td>
		<td>分类</td>
		<td>导演</td>
		<td>发行日期</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page.list }" var="list">
		<tr>
			<td>
				<input type="checkbox" value="${list.mid }">
			</td>
			<td>${list.mid }</td>
			<td>${list.mname }</td>
			<td>${list.introduction }</td>
			<td>${list.snames }</td>
			<td>${list.auther }</td>
			<td>${list.startdate }</td>
			<td>
				<a href="updateMovies.jsp?mid=${list.mid }"><input type="button" value="修改"></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			<a href="add.do"><input type="button" value="添加"></a>
			<input type="button" value="批量删除" onclick="delAll()">
			<br>
			当前页${page.pageNum }/共${page.pages }页
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${page.pageNum-1<1?1:page.pageNum-1 }">上一页</a>
			<a href="?pageNum=${page.pageNum+1>page.pages?page.pages:page.pageNum+1 }">下一页</a>
			<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
</table>
</body>
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#b1").toggle(
			function(){
			 $(":checkbox").prop("checked",true);
		},
			function(){
			$(":checkbox").prop("checked",false);
		});
		
		$("#b2").click(function(){
			$(":checkbox").each(function(){
				this.checked = !this.checked;
			});
		});
	});
	
	function delAll(){
		var mids = $(":checkbox:checked").map(function(){
			return $(this).val();
		}).get().join(",");
		var b = confirm("确定要删除吗？");
		if(b){
			$.post("delAll.do","mids="+mids,function(data){
				if(data.trim()=="succ"){
					alert("删除成功");
					window.location.reload();
				}else{
					alert("删除失败。。。");
				}
			});
		}
	}
</script>
</html>