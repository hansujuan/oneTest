<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<input type="hidden" name="mid">
电影名称：<input type="text" name="mname"><br><br>
电影分类：<div id="d"></div>
<br><br>
剧情介绍：<textarea rows="5" cols="50" name="introduction"></textarea><br><br>
导演：<input type="text" name="auther"><br><br>
发行日期：<input type="date" name="startdate"><br><br>
<input type="button" value="更新" onclick="updateMovies()">
</form>
</body>
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		update();
	});
	function update(){
		var mid = ${param.mid};
		$.post("updateMovies.do","mid="+mid,function(data){
			var slist = data.list;
			var m = data.movies;
			var str = "";
			$("[name='mid']").val(m.mid);
			$("[name='mname']").val(m.mname);
			for ( var i in slist) {
				str += "<input type='checkbox' name='sid' value='"+slist[i].sid+"'>"+slist[i].sname;
			}
			$("#d").html(str);
			var arr = m.sids.split(",");
			$("[name='sid']").each(function () {
				for ( var i in arr) {
					if(arr[i]==this.value){
						this.checked=true;
					}
				}
			});
			$("[name='introduction']").html(m.introduction);
			$("[name='auther']").val(m.auther);
			$("[name='startdate']").val(m.startdate);
		},"json");
	}
	
	function updateMovies(){
		var val = $("form").serialize();
		$.post("updateMoviesById.do",val,function(data){
			if(data.trim()=="succ"){
				alert("修改成功");
				window.location.href="list.do";
			}else{
				alert("修改失败。。。");
			}
		});
	}
</script>
</html>