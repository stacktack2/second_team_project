package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("noticeList")) {
			noticeList(request,response);
		}else if(threeUri.equals("noticeModify")) {
			noticeModify(request,response);			
		}else if(threeUri.equals("noticeView")) {
			noticeView(request,response);			
		}else if(threeUri.equals("noticeWrite")) {
			noticeWrite(request,response);			
		}
	}
	
	public void noticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeList.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void noticeModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeModify.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void noticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeView.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void noticeWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeWrite.jsp");
		rd.forward(request, response);
		
		
	}
	
	
}
