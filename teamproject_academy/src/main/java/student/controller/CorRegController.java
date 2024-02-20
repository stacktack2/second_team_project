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

		String sno = (String)request.getSession().getAttribute("no");
		if(sno == null || (sno != null && sno.equals(""))) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		CorRegDAO corRegDAO = new CorRegDAO();

		List<Map<String, Object>> regList = corRegDAO.selectRegAll( sno);
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
		String sno = (String)request.getSession().getAttribute("no");
		if(sno == null || (sno != null && sno.equals(""))) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		CorRegDAO corRegDAO = new CorRegDAO();
		int courseRs = corRegDAO.updateReg(lno, sno);
		request.setAttribute("courseRs", courseRs);

		//[ajax에 data보내기]
		if(courseRs >0) {
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("SUCCESS");
			response.getWriter().flush();
		}else {
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("FAIL");
			response.getWriter().flush();
		}
		
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
