package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.NoticeDAO;
import vo.BoardVO;
import vo.StudentVO;

public class NoticeController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String threeUri = threeUriParam.split("\\.")[0];
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		sno=5;
		NoticeDAO noticeDAO = new NoticeDAO();
		StudentVO student = noticeDAO.selectSnameByOne(sno);
		request.setAttribute("student", student);
		
		switch(threeUriParam) {
			case "noticeList":
				noticeList(request, response);
				break;
			case "noticeView":
				noticeView(request, response);
				break;
				
		}
		
//		if(threeUri.equals("noticeList")) {
//			noticeList(request,response);
//		}else if(threeUri.equals("noticeView")) {
//			noticeView(request,response);			
//		}

		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("noticeList")) {
			noticeList(request,response);
		}else if(threeUri.equals("noticeView")) {
			noticeView(request,response);			
		}
		
	}
	
	public void noticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDAO noticeDAO = new NoticeDAO();
		List<BoardVO> noticeList = noticeDAO.selectBoardAll();
		
		request.setAttribute("noticeList", noticeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/notice/noticeList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostnoticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/notice/noticeList.jsp");
		rd.forward(request, response);
		
		
	}
	public void noticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bnoParam = request.getParameter("bno");
		int bno = 0;
		if(bnoParam != null && !bnoParam.equals("")) {
			bno = Integer.parseInt(bnoParam);
		}
		
		NoticeDAO noticeDAO = new NoticeDAO();
		BoardVO board = noticeDAO.selectBoardByOne(bno);
		
		request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/notice/noticeView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostnoticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/notice/noticeView.jsp");
		rd.forward(request, response);
		
		
	}
	
}
