package student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.AtdGradeDAO;
import vo.StudentVO;

public class AtdGradeController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String threeUri = threeUriParam.split("\\.")[0];
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		sno=5;
		AtdGradeDAO atdGradeDAO = new AtdGradeDAO();
		StudentVO student = atdGradeDAO.selectSnameByOne(sno);
		request.setAttribute("student", student);
		
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
		/*
		 * String snoParam = request.getParameter("sno"); int sno = 0; if(snoParam !=
		 * null && !snoParam.equals("")) { sno = Integer.parseInt(snoParam); }
		 */
		//임의숫자
		//System.out.println("call :: cgradeCheck");
		int sno=1;
		
		AtdGradeDAO atdGradeDAO = new AtdGradeDAO();
		List<Map<String, Object>> courseList = atdGradeDAO.selectCourseAll(sno);
		request.setAttribute("courseList", courseList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendcheckList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckList.jsp");
		rd.forward(request, response);
		
		
	}
	public void attendcheckView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String snoParam = request.getParameter("sno"); int sno = 0; if(snoParam !=
		 * null && !snoParam.equals("")) { sno = Integer.parseInt(snoParam); }
		 */
		//임의숫자
		//System.out.println("call :: cgradeCheck");
		int sno=1;
		AtdGradeDAO atdGradeDAO = new AtdGradeDAO();
		List<Map<String, Object>> attendList = atdGradeDAO.selectAttendAll(sno);
		request.setAttribute("attendList", attendList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendcheckView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/attendcheckView.jsp");
		rd.forward(request, response);
		
		
	}
	public void cgradeCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String snoParam = request.getParameter("sno"); int sno = 0; if(snoParam !=
		 * null && !snoParam.equals("")) { sno = Integer.parseInt(snoParam); }
		 */
		//임의숫자
		//System.out.println("call :: cgradeCheck");
		int sno=1;
		AtdGradeDAO atdGradeDAO = new AtdGradeDAO();
		List<Map<String, Object>> gradeList = atdGradeDAO.selectgradeAll(sno);
		System.out.println("cgradeCheck : " + gradeList.size());
		request.setAttribute("gradeList", gradeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/cgradeCheck.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostcgradeCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/atdGrade/cgradeCheck.jsp");
		rd.forward(request, response);
		
		
	}
	
}
