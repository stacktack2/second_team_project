package admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.mindrot.jbcrypt.BCrypt;

import admin.dao.UserManageDAO;
import vo.PagingVO;
import vo.ProfessorVO;

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
		
		String pid = request.getParameter("pid");
		String ppwParam = request.getParameter("ppw");
			   ppwParam = pid;
			   System.out.println(ppwParam);
		String ppw = BCrypt.hashpw(ppwParam, BCrypt.gensalt());
		String pname = request.getParameter("pname");
		String pregNo1 = request.getParameter("pregNo1");
		String pregNo2 = request.getParameter("pregNo2");
		String pbirth = request.getParameter("pbirth");
		String pgender = request.getParameter("pgender");
		String pposition = request.getParameter("pposition");
		String puniv = request.getParameter("puniv");
		String pfaculty = request.getParameter("pfaculty");
		String pmajor = request.getParameter("pmajor");
		String pdegree = request.getParameter("pdegree");
		String plab = request.getParameter("plab");
		String pappointDate = request.getParameter("pappointDate");
		String pemail = request.getParameter("pemail");
		String pphone = request.getParameter("pphone");
		String pcall = request.getParameter("pcall");
		String paddr = request.getParameter("paddr");
		String pzipcode = request.getParameter("pzipcode");
		
		String[] profUserAdd = {pid, ppw, pname, pregNo1, pregNo2, pbirth, pgender, pposition,
	            puniv, pfaculty, pmajor, pdegree, plab, pappointDate, pemail, pphone, pcall, paddr, pzipcode};
		
		System.out.println(profUserAdd);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		UserManageDAO userManageDAO = new UserManageDAO();
		List<ProfessorVO> profAdd = userManageDAO.insertProf(profUserAdd);
		
		request.setAttribute("profAdd", profAdd);
		
		
//		if(profUserAdd != null) {
//			response.sendRedirect(request.getContextPath()+"/admin/profUserMgView");
//		}else {
//			response.setContentType("text/html; charset=utf-8");
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().append("<script>alert('로그인에 실패하였습니다.'); location.href='"+request.getContextPath()+"/';</script>");
//			response.getWriter().flush();
//		}
		
		
		
		
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

//	교수 사용자 관리 페이지 
//	GET	
	public void profUserMgList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		교수 목록		
		UserManageDAO userManageDAO = new UserManageDAO();
		List<ProfessorVO> professorList = userManageDAO.selectProf();
		
		request.setAttribute("professorList", professorList);
		
		int totalCnt = professorList.size();
		
//		검색
		String searchValue = request.getParameter("searchValue");
		
// 		검색 결과가 있을 경우 검색 결과를 전달
		if (searchValue != null && !searchValue.isEmpty()) {
	        List<ProfessorVO> searchResults = userManageDAO.searchProf(searchValue);
	        request.setAttribute("professorList", searchResults);
	        
	        totalCnt = searchResults.size();
	    }
		
//		페이징
		int nowPage = 1;
	    int perPage = 5;

	    PagingVO pagingVO = new PagingVO(nowPage, totalCnt, perPage);

	    List<ProfessorVO> pagingList = userManageDAO.selectProfPaging(pagingVO.getStart(), perPage);

	    request.setAttribute("pagingVO", pagingVO);
	    request.setAttribute("pagingList", pagingList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userManage/profUserMgList.jsp");
		rd.forward(request, response);
	}
	
//	POST
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
