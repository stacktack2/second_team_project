package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorRegController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("cAppCheck")) {
			cAppCheck(request,response);
		}else if(threeUri.equals("corReg")) {
			corReg(request,response);			
		}
		
	}
	
	public void cAppCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/cAppCheck.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void corReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/student/corReg/corReg.jsp");
		rd.forward(request, response);
		
		
	}
	
	
}
