<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>上传文件</title>
</head>
<body>
 <form  method="post"  action="UploadServlet" enctype="multipart/form-data" >
 选择2文件:<input  type="file" name="filename"><br>
 <input type="submit" name="submit" value="上传">
 </form>
</body>
</html>











