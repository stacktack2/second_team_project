package student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.CorRegDAO;
import vo.CourseVO;
import vo.StudentVO;

public class CorRegController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		sno=5;
		CorRegDAO corRegDAO = new CorRegDAO();
		StudentVO student = corRegDAO.selectSnameByOne(sno);
		request.setAttribute("student", student);
		
		switch (threeUriParam) {
			case "cAppCheck":
				cAppCheck(request,response);
				break;
			case "corReg":
				corReg(request,response);
				break;
		}

	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("cAppCheck")) {
			PostcAppCheck(request,response);
		}else if(threeUri.equals("corReg")) {
			PostcorReg(request,response);			
		}
		
	}
	//수강신청 현황조회
	public void cAppCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[ajax에서 가져온 lno]
		String lnoParam = request.getParameter("lno");
		int lno=0;
		if(lnoParam != null && !lnoParam.equals("")) {
			lno = Integer.parseInt(lnoParam);
		}
		String snoParam = request.getParameter("sno");
		int sno = 0;
		sno=5;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		CorRegDAO corRegDAO = new CorRegDAO();
		List<CourseVO> regList = corRegDAO.selectRegAll(lno, sno);
		request.setAttribute("regList", regList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/cAppCheck.jsp");
		rd.forward(request, response);
	}
	public void PostcAppCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[ajax에서 가져온 lno]
		String lnoParam = request.getParameter("lno");
		int lno=0;
		if(lnoParam != null && !lnoParam.equals("")) {
			lno = Integer.parseInt(lnoParam);
		}
		String snoParam = request.getParameter("sno");
		int sno = 0;
		sno=5;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		
		CorRegDAO corRegDAO = new CorRegDAO();
		List<CourseVO> regUpdate = corRegDAO.updateReg(lno, sno);
		request.setAttribute("regUpdate", regUpdate);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/cAppCheck.jsp");
		rd.forward(request, response);
		
	}
	//수강신청조회
	public void corReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[검색]
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		CorRegDAO corRegDAO = new CorRegDAO();
		List<Map<String, Object>> corRegList = corRegDAO.selectCorRegAll(searchType,searchValue);
		request.setAttribute("corRegList",corRegList);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/corReg.jsp");
		rd.forward(request, response);
		
	}
	public void PostcorReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/corReg.jsp");
		rd.forward(request, response);
		
		
	}
	
}
