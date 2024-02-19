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
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		sno=5;
		MypageDAO mypageDAO = new MypageDAO();
		StudentVO student = mypageDAO.selectSnameByOne(sno);
		request.setAttribute("student", student);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/mypage/myInfoModify.jsp");
		rd.forward(request, response);
	}
	public void doPostAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/mypage/myInfoModify.jsp");
		rd.forward(request, response);
	}
}
