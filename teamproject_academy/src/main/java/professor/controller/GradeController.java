package professor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GradeController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("gradeMgList")) {
			gradeMgList(request,response);
		}else if(threeUri.equals("gradeMgView")) {
			gradeMgView(request,response);			
		}
		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("gradeMgList")) {
			PostgradeMgList(request,response);
		}else if(threeUri.equals("gradeMgView")) {
			PostgradeMgView(request,response);			
		}
		
	}
	public void gradeMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/grade/gradeMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostgradeMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/grade/gradeMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void gradeMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/grade/gradeMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostgradeMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/grade/gradeMgView.jsp");
		rd.forward(request, response);
		
		
	}
}
