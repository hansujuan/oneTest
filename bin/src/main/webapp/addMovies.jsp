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
<h1 align="center" style="font-size: 34px;">修改电影信息</h1>
<form action="">
电影名称：<input type="text" name="mname"><br><br>
电影分类：
<c:forEach items="${list}" var="s">
	<input type="checkbox" name="sid" value="${s.sid }">${s.sname }
</c:forEach><br><br>
剧情介绍：<textarea rows="5" cols="50" name="introduction"></textarea><br><br>
导演：<input type="text" name="auther"><br><br>
发行日期：<input type="date" name="startdate"><br><br>
<input type="button" value="保存" onclick="addMovies()">
</form>
</body>
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function addMovies(){
		var val = $("form").serialize();
		$.post("addMovies.do",val,function(data){
			if(data.trim()=="succ"){
				window.location.href="succ.jsp";
			}else{
				alert("数据添加错误，造成添加失败，请重新输入添加信息");
			}
		});
	}
</script>
</html>