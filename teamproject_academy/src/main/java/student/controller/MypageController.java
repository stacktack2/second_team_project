package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.MypageDAO;
import vo.StudentVO;

public class MypageController {
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = (String)request.getSession().getAttribute("no");
		if(sno == null || (sno != null && sno.equals(""))) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/mypage/myInfoModify.jsp");
		rd.forward(request, response);
	}
	public void doPostAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/mypage/myInfoModify.jsp");
		rd.forward(request, response);
	}
}
