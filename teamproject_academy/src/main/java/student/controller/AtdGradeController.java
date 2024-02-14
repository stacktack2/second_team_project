package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtdGradeController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String threeUri = threeUriParam.split("\\.")[0];
		
		switch(threeUriParam) {
		case "attendcheckList":
			attendcheckList(request,response);
			break;
		case "attendcheckView":
			attendcheckView(request,response);
			break;
		case "cgradeCheck":
			cgradeCheck(request,response);
			break;
	}

//		if(threeUriParam.equals("attendcheckList")) {
//			attendcheckList(request,response);
//		}else if(threeUriParam.equals("attendcheckView")) {
//			attendcheckView(request,response);			
//		}else if(threeUriParam.equals("cgradeCheck")) {
//			cgradeCheck(request,response);			
//		}
		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String threeUri = threeUriParam.split("\\.")[0];

		if(threeUriParam.equals("attendcheckList")) {
			PostattendcheckList(request,response);
		}else if(threeUriParam.equals("attendcheckView")) {
			PostattendcheckView(request,response);			
		}else if(threeUriParam.equals("cgradeCheck")) {
			PostcgradeCheck(request,response);			
		}
		
	}
	public void attendcheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendcheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckList.jsp");
		rd.forward(request, response);
		
		
	}
	public void attendcheckView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendcheckView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckView.jsp");
		rd.forward(request, response);
		
		
	}
	public void cgradeCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/cgradeCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostcgradeCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/cgradeCheck.jsp");
		rd.forward(request, response);
		
		
	}
	
}
