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
		//ʹ��apache�ϴ����,��request�еõ��ϴ����ļ�������
		//Ȼ�������� �洢�� tomcat��һ��Ŀ¼����,���
		
	  try {
			// ����Request�����ȡ�ͻ��ύ�ĺ��ִ����ʱ�򣬻��������
			request.setCharacterEncoding("UTF-8"); // ���ô�����������ı����ʽ
			response.setContentType("text/html;charset=UTF-8"); // ����Content-Type�ֶ�ֵ
			PrintWriter out = response.getWriter();
			
		  FileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
		  List<FileItem> items = upload.parseRequest(request);  //�õ��ϴ��Ķ���ļ�����
		  //ȡ����һ���ϴ����ļ�
		  FileItem fileItem= items.get(0); 
		  //�õ��ϴ����ļ�����·��  name="filename"; filename="17737.gif"
		
		  String filename= fileItem.getName();
		  System.out.println("sss====================="+filename);
		  InputStream in=fileItem.getInputStream();//�ļ���������
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
	 System.out.println("�ϴ��ɹ�");
	} catch (Exception e) {
	 	e.printStackTrace();
	}
 }
 
}
