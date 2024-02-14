package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserManageController {
	
	public void doAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch(threeUriParam) {
			case "stuUserAdd":
				stuUserAdd(request,response);
				break;
			case "profUserAdd":
				profUserAdd(request,response);
				break;
			case "stuUserInfoModify":
				stuUserInfoModify(request,response);
				break;
			case "profUserInfoModify":
				profUserInfoModify(request,response);
				break;
			case "stuUserMgList":
				stuUserMgList(request,response);	
				break;
			case "profUserMgList":
				profUserMgList(request,response);	
				break;
			case "stuUserMgView":
				stuUserMgView(request,response);	
				break;
			case "profUserMgView":
				profUserMgView(request,response);	
				break;
			default:
				break;
		}
		
//		String threeUri = threeUriParam.split("\\.")[0];
//
//		if(threeUri.equals("stuUserAdd")) {
//			stuUserAdd(request,response);
//		}else if(threeUri.equals("profUserAdd")) {
//			profUserAdd(request,response);
//		}else if(threeUri.equals("stuUserInfoModify")) {
//			stuUserInfoModify(request,response);			
//		}else if(threeUri.equals("profUserInfoModify")) {
//			profUserInfoModify(request,response);			
//		}else if(threeUri.equals("stuUserMgList")) {
//			stuUserMgList(request,response);			
//		}else if(threeUri.equals("profUserMgList")) {
//			profUserMgList(request,response);			
//		}else if(threeUri.equals("stuUserMgView")) {
//			stuUserMgView(request,response);			
//		}else if(threeUri.equals("profUserMgView")) {
//			profUserMgView(request,response);			
//		}
	}
	
	public void doPostAction(String threeUriParam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String threeUri = threeUriParam.split("\\.")[0];

		if(threeUri.equals("stuUserAdd")) {
			PoststuUserAdd(request,response);
		}else if(threeUri.equals("profUserAdd")) {
			PostprofUserAdd(request,response);			
		}else if(threeUri.equals("stuUserInfoModify")) {
			PoststuUserInfoModify(request,response);			
		}else if(threeUri.equals("profUserInfoModify")) {
			PostprofUserInfoModify(request,response);			
		}else if(threeUri.equals("stuUserMgList")) {
			PoststuUserMgList(request,response);			
		}else if(threeUri.equals("profUserMgList")) {
			PostprofUserMgList(request,response);			
		}else if(threeUri.equals("stuUserMgView")) {
			PoststuUserMgView(request,response);			
		}else if(threeUri.equals("profUserMgView")) {
			PostprofUserMgView(request,response);			
		}
	}
	
	public void stuUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserAdd.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void PoststuUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserAdd.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void profUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserAdd.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void PostprofUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserAdd.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void stuUserInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserInfoModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void PoststuUserInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserInfoModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void profUserInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserInfoModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostprofUserInfoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserInfoModify.jsp");
		rd.forward(request, response);
		
		
	}
	public void stuUserMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PoststuUserMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void profUserMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostprofUserMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserMgList.jsp");
		rd.forward(request, response);
		
		
	}
	public void stuUserMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PoststuUserMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/stuUserMgView.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void profUserMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserMgView.jsp");
		rd.forward(request, response);
		
		
	}
	public void PostprofUserMgView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserMgView.jsp");
		rd.forward(request, response);
		
		
	}

	
	
}
