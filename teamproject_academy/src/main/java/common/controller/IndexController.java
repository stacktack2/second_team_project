package common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

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
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		
		
		
		// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성
		// passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
//		String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt());

		// 위 문장은 아래와 같다. 숫자가 높아질수록 해쉬를 생성하고 검증하는 시간은 느려진다.
		// 즉, 보안이 우수해진다. 하지만 그만큼 응답 시간이 느려지기 때문에 적절한 숫자를 선정해야 한다. 기본값은 10이다.
		String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt(10));

		// 생성된 해쉬를 원래 비밀번호로 검증한다. 맞을 경우 true를 반환한다.
		// 주로 회원 로그인 로직에서 사용된다.
		boolean isValidPassword = BCrypt.checkpw(password, passwordHashed);
		
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
