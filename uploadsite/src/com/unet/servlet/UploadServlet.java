package com.unet.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    String path="D:\\eclipse-jee-2018-09-win32-x86_64\\eclipse\\eclipse-workspace\\uploadsite\\WebContent\\upload\\"; 
 	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("===========service====dd===========");
		//使用apache上传组件,从request中得到上传的文件（流）
		//然后把这个流 存储到 tomcat的一个目录里面,完成
		
	  try {
			// 当用Request对象获取客户提交的汉字代码的时候，会出现乱码
			request.setCharacterEncoding("UTF-8"); // 设置处理请求参数的编码格式
			response.setContentType("text/html;charset=UTF-8"); // 设置Content-Type字段值
			PrintWriter out = response.getWriter();
			
		  FileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
		  List<FileItem> items = upload.parseRequest(request);  //得到上传的多个文件对象
		  //取到第一个上传的文件
		  FileItem fileItem= items.get(0); 
		  //得到上传的文件名及路径  name="filename"; filename="17737.gif"
		
		  String filename= fileItem.getName();
		  System.out.println("sss====================="+filename);
		  InputStream in=fileItem.getInputStream();//文件流，乱码
		  System.out.println(path+filename);
		  File file=new File(path+filename);
	  	  FileOutputStream fos=new FileOutputStream(file);
		  int i=0;
		  byte[] buffer=new byte[1024];
		  while((i=in.read(buffer))!=-1){
		    fos.write(buffer, 0, i); 
		  }
		  fos.flush();
		  in.close();
		  fos.close();
	 System.out.println("上传成功");
	} catch (Exception e) {
	 	e.printStackTrace();
	}
 }
 
}
