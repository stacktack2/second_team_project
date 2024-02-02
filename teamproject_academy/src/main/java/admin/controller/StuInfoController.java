package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuInfoController {
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("absenseMgList")) {
			absenseMgList(request,response);
		}else if(threeUri.equals("absenseMgView")) {
			absenseMgView(request,response);			
		}else if(threeUri.equals("attendMgList")) {
			attendMgList(request,response);			
		}else if(threeUri.equals("attendMgView")) {
			attendMgView(request,response);			
		}else if(threeUri.equals("gradeMgList")) {
			gradeMgList(request,response);			
		}else if(threeUri.equals("gradeMgView")) {
			gradeMgView(request,response);			
		}
	}
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("absenseMgList")) {
			PostabsenseMgList(request,response);
		}else if(threeUri.equals("absenseMgView")) {
			PostabsenseMgView(request,response);			
		}else if(threeUri.equals("attendMgList")) {
			PostattendMgList(request,response);			
		}else if(threeUri.equals("attendMgView")) {
			PostattendMgView(request,response);			
		}else if(threeUri.equals("gradeMgList")) {
			PostgradeMgList(request,response);			
		}else if(threeUri.equals("gradeMgView")) {
			PostgradeMgView(request,response);			
		}
	}
	
	public void absenseMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/absenseMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostabsenseMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/absenseMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void absenseMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/absenseMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostabsenseMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/absenseMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void attendMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/attendMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/attendMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void attendMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/attendMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostattendMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/attendMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void gradeMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/gradeMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostgradeMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/gradeMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void gradeMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/gradeMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostgradeMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/stuInfo/gradeMgView.jsp");
		rd.forward(request, response);
		
		
	}
	
}
