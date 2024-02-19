package student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.AcdCourseDAO;
import vo.StudentVO;

public class AcdCourseController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//네비헤더에 sname 출력
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}	
		sno=5;
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		StudentVO student = acdCourseDAO.selectSnameByOne(sno);
		request.setAttribute("student", student);
		
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
	
	//휴복학신청
	public void absenseApp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String snoParam = request.getParameter("sno"); 
		 int sno = 0; 
		 if(snoParam != null && !snoParam.equals("")) {
			 sno = Integer.parseInt(snoParam); 
		}
		 sno=5;
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		List<Map<String, Object>> absenseList = acdCourseDAO.selectAbsenseAll(sno);
		request.setAttribute("absenseList", absenseList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/absenseApp.jsp");
		rd.forward(request, response);
	}
	public void PostabsenseApp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/absenseApp.jsp");
		rd.forward(request, response);
	}
	
	//강의계획서 조회
	public void curriculum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lnoParam = request.getParameter("lno");
		int lno = 0;
		if(lnoParam != null && !lnoParam.equals("")) {
			lno = Integer.parseInt(lnoParam);
		}
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		
		Map<String, Object> curriMap = acdCourseDAO.selectCurriByOne(lno);
		request.setAttribute("curriMap", curriMap);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/curriculum.jsp");
		rd.forward(request, response);
	}
	public void Postcurriculum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/curriculum.jsp");
		rd.forward(request, response);
	}
	//수업시간표 조회
	public void scheduleCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		sno=5;
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		
		List<Map<String, Object>> scheduleList = acdCourseDAO.selectScheduleAll(sno);
		request.setAttribute("scheduleList", scheduleList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/scheduleCheck.jsp");
		rd.forward(request, response);
	}
	public void PostscheduleCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/scheduleCheck.jsp");
		rd.forward(request, response);
	}
	//학적사항 조회
	public void sscheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String snoParam = request.getParameter("sno"); 
		 int sno = 0; 
		 if(snoParam !=
		 null && !snoParam.equals("")) {
			 sno = Integer.parseInt(snoParam); 
		}
		 sno=5;
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		Map<String, Object> sscheckMap = acdCourseDAO.selectsscheckByOne(sno);
		request.setAttribute("sscheckMap", sscheckMap);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/sscheck.jsp");
		rd.forward(request, response);
	}
	public void Postsscheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/sscheck.jsp");
		rd.forward(request, response);
	}
	//교과목 조회
	public void subcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcdCourseDAO acdCourseDAO = new AcdCourseDAO();
		List<Map<String, Object>> courseList = acdCourseDAO.selectCourseAll();
		request.setAttribute("courseList", courseList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/subcheck.jsp");
		rd.forward(request, response);
	}
	public void Postsubcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/acdCourse/subcheck.jsp");
		rd.forward(request, response);
	}
	
}
