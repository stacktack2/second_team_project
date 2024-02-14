<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의계획서 수정</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 상단 nav 바 -->
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!--로고자리-->
            <a class="navbar-brand ps-3"
			href="<%=request.getContextPath()%>/admin/admMain">이젠대학교</a>
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
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/notice/noticeList">공지사항 관리</a>
                             <div class="sb-sidenav-menu-heading">사용자 관리</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/userManage/stuUserMgList">학생 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/userManage/profUserMgList">교수 관리</a>
                              
                              <div class="sb-sidenav-menu-heading">학생 정보</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/gradeMgList">학생 성적 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/attendMgList">학생 출결 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/stuInfo/absenseMgList">학생 휴복학 관리</a>
                              
                              <div class="sb-sidenav-menu-heading">강의 관리</div>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/course/courMgList">강의 관리</a>
                              <a class="nav-link" href="<%=request.getContextPath()%>/admin/course/courseRegList">수강신청 열기/닫기</a>
                         </div>
                      </div>
                 </nav>
                </div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">강의계획서 수정</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">강의 관리</li>
						<li class="breadcrumb-item active">강의계획서 조회</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">강의계획서 조회</div>
						<div class="card-body">
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<div class=""></div>
								<div class="datatable-container">
									<div class="datatable-top">
										<button class="btn btn-primary grey right mright">뒤로가기</button>
									</div>
									<!-- 테이블 -->
									<table class="datatable-table viewtable sschecktable">
										<tbody>
											<tr>
												<th>교과목명</th>
												<td colspan="3"></td>
												<th>년도/학기</th>
												<td></td>
											</tr>
											<tr>
												<th>강의시간(강의실)</th>
												<td></td>
												<th>학점/시간</th>
												<td></td>
												<th>이수구분</th>
												<td></td>
											</tr>
											<tr>
												<th>담당교수</th>
												<td></td>
												<th>연락처</th>
												<td></td>
												<th>이메일</th>
												<td></td>
											</tr>
											<tr>
												<th>장애학생 지원</th>
												<td colspan="5">장애학생 수강 시, 학습 지원(장애학생지원실에 등록된 학생의 요청 시
													지정 좌석 제공 등)</td>
											</tr>
											<tr>
												<th>교과목 개요</th>
												<td colspan="5">ㅇㅇㅇ의 기초부분을 공부하여, ㅇㅇㅇ에 대한 이해를 돕는다.</td>
											</tr>
											<tr>
												<th style="vertical-align: middle">학습목표 및 학습방법</th>
												<td colspan="5">ㅇㅇㅇ를 정의하고, 이들의 구조 및 성질을 이해하고, ㅇㅇㅇ의 성질등을
													파악하여 ㅇㅇㅇ의 현황, 응용실태 및 향후 연구개발 방향을 논의한다. 수강 후 ㅇㅇㅇ의 이해를 통하여
													ㅇㅇㅇ업계의 취업시 업무 추진 능력을 배양하고, 진학 및 연속 연구 수행시 ㅇㅇㅇ에 관련된 학문을 깊이있게
													추진할 수 있는 소양을 닦는다.</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="datatable-bottom d-inline-block offset-12">
									<a href="curriculum" class="btn btn-primary grey right mright">저장</a>
								</div>
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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/share/js/scripts.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/share/js/datatables-simple-demo.js"></script>

</body>
</html>