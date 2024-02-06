<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    	<!-- 상단 nav 바 -->
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!--로고자리-->
            <a class="navbar-brand ps-3"
			href="<%=request.getContextPath()%>/admin/admMain.do">이젠대학교</a>
            <!--좌측 nav바 토글(클릭시 없어졌다 있어졌다) -->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- 우측상단 사용자 메뉴-->
	 		<div class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            	<span class="hello">홍길동 관리자님 안녕하세요  </span>
            </div>
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- 좌측 nav 바 -->
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                             <div class="sb-sidenav-menu-heading">공지사항</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/notice/noticeList.do">공지사항 관리</a>
                             <div class="sb-sidenav-menu-heading">사용자 관리</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/userManage/stuUserMgList.do">학생 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/userManage/profUserMgList.do">교수 관리</a>
                              
                              <div class="sb-sidenav-menu-heading">학생 정보</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/gradeMgList.do">학생 성적 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/attendMgList.do">학생 출결 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/absenseMgList.do">학생 휴복학 관리</a>
                              
                              <div class="sb-sidenav-menu-heading">강의 관리</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/course/courMgList.do">강의 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/course/courseRegList.do">수강신청 열기/닫기</a>
                         </div>
                      </div>
                 </nav>
                </div>
            
            
            <!-- 메인페이지 -->
            <div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">학생 사용자 정보</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">사용자 관리</li>
						<li class="breadcrumb-item active">학생 관리</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">학생 정보 조회</div>
						<div class="card-body">
							<div class="card mb-4">
								<div class="card-body">사진</div>
							</div>
							<div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<div class="datatable-container">
									<table class="datatable-table viewtable sschecktable">
										<tbody>
											<tr>
												<th>학번</th>
												<td></td>
												<th>성명</th>
												<td></td>
												<th>주민번호</th>
												<td></td>
											</tr>
											<tr>
												<th>생년월일</th>
												<td></td>
												<th>성별</th>
												<td></td>
												<th>학적상태</th>
												<td></td>
											</tr>
											<tr>
												<th>대학</th>
												<td></td>
												<th>학부</th>
												<td></td>
												<th>전공</th>
												<td></td>
											</tr>
											<tr>
												<th>학년</th>
												<td></td>
												<th>학과석차</th>
												<td></td>
												<th>입학일자</th>
												<td></td>
											</tr>
											<tr>
												<th>제적일자</th>
												<td></td>
												<th>수료일자</th>
												<td></td>
												<th>졸업일자</th>
												<td></td>
											</tr>
											<tr>
												<th>E-mail</th>
												<td></td>
												<th>휴대전화번호</th>
												<td></td>
												<th>집전화번호</th>
												<td></td>
											</tr>
											<tr>
												<th>주소</th>
												<td colspan="3"></td>
												<th>우편번호</th>
												<td></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- 테이블 바텀 -->
							<div class="datatable-bottom ms-auto d-inline-block">
								<a href="stuUserInfoModify.do" class="btn btn-primary grey right mright">수정</a>
							</div>
							<div class="datatable-bottom ms-auto d-inline-block">
								<a href="stuUserMgList.do" class="btn btn-primary grey right mright">목록</a>
							</div>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; 이젠대학교 2023</div>
					</div>
				</div>
			</footer>
		</div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/share/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/share/js/datatables-simple-demo.js"></script>
    </body>
</html>