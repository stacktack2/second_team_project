package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcdCourseController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(threeUriParam);

		switch(threeUriParam) {
			case "absenseApp":
				absenseApp(request,response);
				break;
			case "curriculum":
				curriculum(request,response);
				break;
			case "scheduleCheck":
				scheduleCheck(request,response);
				break;
			case "sscheck":
				sscheck(request,response);
				break;
			case "subcheck":
				subcheck(request,response);
				break;
		}
		
//		if(threeUriParam.equals("absenseApp")) {
//			absenseApp(request,response);
//		}else if(threeUriParam.equals("curriculum")) {
//			curriculum(request,response);			
//		}else if(threeUriParam.equals("scheduleCheck")) {
//			scheduleCheck(request,response);			
//		}else if(threeUriParam.equals("sscheck")) {
//			sscheck(request,response);			
//		}else if(threeUriParam.equals("subcheck")) {
//			subcheck(request,response);			
//		}
		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("absenseApp")) {
			PostabsenseApp(request,response);
		}else if(threeUri.equals("curriculum")) {
			Postcurriculum(request,response);			
		}else if(threeUri.equals("scheduleCheck")) {
			PostscheduleCheck(request,response);			
		}else if(threeUri.equals("sscheck")) {
			Postsscheck(request,response);			
		}else if(threeUri.equals("subcheck")) {
			Postsubcheck(request,response);			
		}
		
	}
	
	public void absenseApp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/absenseApp.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostabsenseApp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/absenseApp.jsp");
		rd.forward(request, response);
		
		
	}
	public void curriculum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/curriculum.jsp");
		rd.forward(request, response);
		
		
	}
	public void Postcurriculum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/curriculum.jsp");
		rd.forward(request, response);
		
		
	}
	public void scheduleCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/scheduleCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostscheduleCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/scheduleCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void sscheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/sscheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void Postsscheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/sscheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void subcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/subcheck.jsp");
		rd.forward(request, response);
		
		
		
	}
	public void Postsubcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/subcheck.jsp");
		rd.forward(request, response);
		
		
		
	}
	
}
