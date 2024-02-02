package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserManageController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("userAdd")) {
			userAdd(request,response);
		}else if(threeUri.equals("userInfoModify")) {
			userInfoModify(request,response);			
		}else if(threeUri.equals("userMgList")) {
			userMgList(request,response);			
		}else if(threeUri.equals("userMgView")) {
			userMgView(request,response);			
		}
	}
	
	public void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/userAdd.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void userInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/userInfoModify.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void userMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/userMgList.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void userMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/userMgView.jsp");
		rd.forward(request, response);
		
		
	}
	
	
}
