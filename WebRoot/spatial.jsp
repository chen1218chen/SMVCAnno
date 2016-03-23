<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                url: "rest/city/getById/"+id,
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
			console.log(name);
			var param={name:name};
			$.ajax({
                type: 'get',
                cache:false,
                url: "rest/city/getByName",
                data: param,
                dataType: 'json',
                success:function(result){
                	console.log("getByName");
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
                url: "rest/city/getAll",
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
			var id=$("#txtID").val();
			var name=$("#txtName").val();
			var coord=$("#txtCoord").val();
			var param={id:id,name:name,coord:coord};
			$.ajax({
                type: 'post',
                url: "rest/city/insert",
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
			var coord=$("#txtCoord").val();
			var param={id:id,name:name,coord:coord};
			$.ajax({
                type: "post",
                url: "rest/city/update",
                data: param,
                dataType: 'json',
                success:function(result){
                	console.log("update");
                	console.log(result);
                }
            });  
		}
		function deleteByID()
		{
			var id=$("#txtID").val();
			$.ajax({
                type: "DELETE",
                url: "rest/city/deleteByID/"+id,
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
	    <dt>空间数据库测试</dt>
	    <dd>
		    id:<input id="txtID" value="4">name:<input id="txtName" value="西安">coord:<input id="txtCoord" value="POINT (108.92 39.75)" style="width:240px;"><br>
		    <button onclick="queryByID()">id查询</button>
		    <button onclick="queryByName()">名称查询</button>
		   	<button onclick="queryAll()">全部查询</button>
		   	<button onclick="insert()">插入</button>
		   	<button onclick="update()">更新</button>
		   	<button onclick="deleteByID()">id删除</button>
	    </dd>
	</dl>
  </body>
</html>
