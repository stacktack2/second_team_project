package common.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import common.dao.FindIdDAO;
import common.dao.indexDAO;

public class IndexController {
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/index.jsp");
		rd.forward(request, response);
		
	}
	
	public void doAction(String twoUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(twoUriParam);
		
		switch (twoUriParam) {
			case "index":
				index(request, response);
				break;
			case "findId":
				findId(request, response);
				break;
			case "findPw":
				findPw(request, response);
				break;
		}
		
//		if(twoUriParam.equals("index")) {
//			index(request,response);
//		}else if(twoUriParam.equals("findId")) {
//			findId(request,response);			
//		}else if(twoUriParam.equals("findPw")) {
//			findPw(request,response);			
//		}
		
		
	}
	
	public void doPostAction(String twoUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String twoUri = twoUriParam.split("\\.")[0];
		
		if(twoUri.equals("index")) {
			Postindex(request,response);
		}else if(twoUri.equals("findId")) {
			PostfindId(request,response);			
		}else if(twoUri.equals("findPw")) {
			PostfindPw(request,response);			
		}
		
		
	}

//	index GET접근
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/index.jsp");
		rd.forward(request, response);
	}
//	index POST접근
	public void Postindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idParam = request.getParameter("id");
		String pwParam = request.getParameter("pw");
		String rememberParam = request.getParameter("inputRememberId");
		
		//해당 id의 데이터베이스 해시된 pw값, BCrypt로 솔트된 해시 값이 들어있다고 가정
		indexDAO indexdao = new indexDAO();
		String[] result = indexdao.selectPw(idParam);
		String pwData = result[0];
		String typeData = result[1];

		
		
		
		//검증
		boolean isValidPassword =false;
		if(pwData != null) {
			isValidPassword = BCrypt.checkpw(pwParam, pwData);
		}
		if(isValidPassword) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/index.jsp");
			request.getSession().setAttribute("type",typeData);
			request.getSession().setAttribute("id",idParam);
			if(typeData.equals("student")) {
				rd = request.getRequestDispatcher("/WEB-INF/student/stuMain.jsp");
			}else if(typeData.equals("professor")) {
				rd = request.getRequestDispatcher("/WEB-INF/professor/profMain.jsp");
			}else if(typeData.equals("administer")) {
				rd = request.getRequestDispatcher("/WEB-INF/admin/admMain.jsp");
			}
			//아이디 기억 쿠키
			if(rememberParam.equals("check")) {
				Cookie cookie = new Cookie("rememberParam",idParam);
				cookie.setMaxAge(60*60*3);
				response.addCookie(cookie);
			}
			rd.forward(request, response);
		}else {
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("<script>alert('로그인에 실패하였습니다.'); location.href='"+request.getContextPath()+"/';</script>");
			response.getWriter().flush();
		}
		
	}
	
	
	public void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/findId.jsp");
		rd.forward(request, response);
	}
	public void PostfindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String type = request.getParameter("selectType");
		String name = request.getParameter("inputName");
		String birth = request.getParameter("inputBirth");
		String phone = request.getParameter("inputPhone");
		
		FindIdDAO findIdDAO = new FindIdDAO();
		String id =null;
		
		if(type.equals("학생")) {
			id = findIdDAO.searchStudentId(name, birth, phone);
		}else if(type.equals("교수")) {
			id = findIdDAO.searchProfessorId(name, birth, phone);
		}
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(id);
		response.getWriter().flush();
		
	}
	
	
	public void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/findPw.jsp");
		rd.forward(request, response);
	}
	public void PostfindPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/findPw.jsp");
		rd.forward(request, response);
	}

}
