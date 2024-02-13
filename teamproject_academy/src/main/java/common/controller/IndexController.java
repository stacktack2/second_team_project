package common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/index.jsp");
		rd.forward(request, response);
	}
	
	public void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/findId.jsp");
		rd.forward(request, response);
	}
	public void PostfindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common/findId.jsp");
		rd.forward(request, response);
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
