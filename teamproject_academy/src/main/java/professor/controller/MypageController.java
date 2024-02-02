package professor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypageController {
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/mypage/myInfoModify.jsp");
		rd.forward(request, response);
		
	}
	
	
		
		
		
	
	
	
	
}
