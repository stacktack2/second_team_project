package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.NoticeDAO;
import vo.BoardVO;

public class NoticeController {
	
	
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch(threeUriParam) {
			case "noticeList":
				noticeList(request,response);
				break;
			case "noticeModify":
				noticeModify(request,response);
				break;
			case "noticeView":
				noticeView(request,response);
				break;
			case "noticeWrite":
				noticeWrite(request,response);
				break;
			default:
				break;
		}
		
//		String threeUri = threeUriParam.split("\\.")[0];
//
//		if(threeUri.equals("noticeList")) {
//			noticeList(request,response);
//		}else if(threeUri.equals("noticeModify")) {
//			noticeModify(request,response);			
//		}else if(threeUri.equals("noticeView")) {
//			noticeView(request,response);			
//		}else if(threeUri.equals("noticeWrite")) {
//			noticeWrite(request,response);			
//		}
	}
	
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("noticeList")) {
			PostnoticeList(request,response);
		}else if(threeUri.equals("noticeModify")) {
			PostnoticeModify(request,response);			
		}else if(threeUri.equals("noticeView")) {
			PostnoticeView(request,response);			
		}else if(threeUri.equals("noticeWrite")) {
			PostnoticeWrite(request,response);			
		}
	}
	
	public void noticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDAO noticeDAO = new NoticeDAO();
		List<BoardVO> noticeList = noticeDAO.selectAll();
		
		request.setAttribute("noticeList", noticeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeList.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void PostnoticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeList.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void noticeModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostnoticeModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void noticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostnoticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeView.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void noticeWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeWrite.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostnoticeWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeWrite.jsp");
		rd.forward(request, response);
		
		
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/notice/noticeList.jsp");
		rd.forward(request, response);
		
	}

	 

	
	
}
