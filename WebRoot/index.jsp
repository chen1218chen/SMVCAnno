<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>测试页面</title>
    <style type="text/css">
    	input
    	{
    		width:60px;
    	}
    </style>
	<script type="text/javascript" src="scripts/jquery.js"></script>
	<script type="text/javascript">
		function queryByID()
		{
			var id=$("#txtID").val();
			$.ajax({
                type: 'get',
                url: "rest/student/getById/"+id,
                data: {},
                dataType: 'json',
                success:function(result){
                	console.log("queryByID");
                	if(result)
                	{
                		console.log(result);
                	}
                }
            });  
		}
		function queryByName()
		{
			var name=$("#txtName").val();
			var param={name:name};
			$.ajax({
                type: 'get',
                url: "rest/student/getByName",
                data: param,
                dataType: 'json',
                success:function(result){
                	console.log("queryByName");
                	if(result)
                	{
                		console.log(result);
                	}
                }
            });  
		}
		function queryAll()
		{
			$.ajax({
                type: 'get',
                url: "rest/student/getAll",
                data: null,
                dataType: 'json',
                success:function(result){
                	console.log("queryAll");
                	if(result)
                	{
                		console.log(result);
                	}
                }
            });  
		}
		function insert()
		{
			var name=$("#txtName").val();
			var pwd=$("#txtPwd").val();
			var param={name:name,pwd:pwd};
			$.ajax({
                type: 'post',
                url: "rest/student/insert",
                data: param,
                dataType:'json',
                success:function(result){
                	console.log("insert");
                	console.log(result);
                }
            });  
		}
		function update()
		{
			var id=$("#txtID").val();
			var name=$("#txtName").val();
			var pwd=$("#txtPwd").val();
			var param={id:id,name:name,pwd:pwd};
			$.ajax({
                type: "post",
                url: "rest/student/update",
                data: param,
                dataType: 'json',
                success:function(result){
                	console.log("update");
                	console.log(result);
                }
            });  
		}
		function deleteS()
		{
			var id=$("#txtID").val();
			var param={id:id};
			$.ajax({
                type: 'post',
                url: "rest/student/delete",
                data: param,
                dataType: 'json',
                success:function(result){
                	console.log("delete");
                	console.log(result);
                }
            });  
		}
		function deleteByID()
		{
			var id=$("#txtID").val();
			$.ajax({
                type: "DELETE",
                url: "rest/student/deleteByID/"+id,
                dataType: 'json',
                success:function(result){
                	console.log("deleteByID");
                	console.log(result);
                }
            });  
		}
	</script>
  </head>
  <body>
    <dl>
	    <dt>关系数据库测试</dt>
	    <dd>
	    <a href="rest/student/demoAction">测试(获取名称)</a><br>
	    id:<input id="txtID">name:<input id="txtName">pwd:<input id="txtPwd"><br>
	    <button onclick="queryByID()">id查询</button>
	    <button onclick="queryByName()">名称查询</button>
	   	<button onclick="queryAll()">全部查询</button>
	    <button onclick="insert()">插入</button>
	    <button onclick="update()">更新</button>
	    <button onclick="deleteS()">删除</button>
	    <button onclick="deleteByID()">id删除</button>
	    </dd>
	</dl>
  </body>
</html>
