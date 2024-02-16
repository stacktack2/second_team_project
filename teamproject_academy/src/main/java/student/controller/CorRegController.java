package student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.CorRegDAO;
import vo.StudentVO;

public class CorRegController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String threeUri = threeUriParam.split("\\.")[0];

		switch (threeUriParam) {
			case "cAppCheck":
				cAppCheck(request,response);
				break;
			case "corReg":
				corReg(request,response);
				break;
		}
		
//		if(threeUri.equals("cAppCheck")) {
//			cAppCheck(request,response);
//		}else if(threeUri.equals("corReg")) {
//			corReg(request,response);			
//		}
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		CorRegDAO corRegDAO = new CorRegDAO();
		StudentVO student = corRegDAO.selectSid(sno);
		request.setAttribute("student", student);
		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("cAppCheck")) {
			PostcAppCheck(request,response);
		}else if(threeUri.equals("corReg")) {
			PostcorReg(request,response);			
		}
		
	}
	public void cAppCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/cAppCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostcAppCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/cAppCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void corReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorRegDAO corRegDAO = new CorRegDAO();
		List<Map<String, Object>> corRegList = corRegDAO.selectCorRegAll();
		request.setAttribute("corRegList",corRegList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/corReg.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostcorReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/corReg.jsp");
		rd.forward(request, response);
		
		
	}
	
}
