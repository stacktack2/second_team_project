package professor.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttendController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String threeUri = threeUriParam.split("\\.")[0];

		switch(threeUriParam) {
			case "attendMgList":
				attendMgList(request,response);
				break;
			case "attendMgView":
				attendMgView(request,response);
				break;
		}
		
//		if(threeUri.equals("attendMgList")) {
//			attendMgList(request,response);
//		}else if(threeUri.equals("attendMgView")) {
//			attendMgView(request,response);			
//		}
		
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("attendMgList")) {
			PostattendMgList(request,response);
		}else if(threeUri.equals("attendMgView")) {
			PostattendMgView(request,response);			
		}
		
	}
	public void attendMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/attend/attendMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/attend/attendMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void attendMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/attend/attendMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/professor/attend/attendMgView.jsp");
		rd.forward(request, response);
		
		
	}
}
