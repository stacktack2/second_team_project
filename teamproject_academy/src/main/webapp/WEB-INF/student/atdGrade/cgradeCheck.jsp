<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적조회</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand ps-3"
			href="<%=request.getContextPath()%>/student/stuMain.do">이젠대학교</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		
		<div class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<span class="hello">홍길동 대학생님 안녕하세요 </span>
		</div>
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					<i class="fas fa-user fa-fw"></i>
				</a>
				<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">로그아웃</a></li>
				</ul>
			</li>
		</ul>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">학적/수강관리</div>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/acdCourse/sscheck.do">학적사항 조회</a> 
						<a class="nav-link"	href="<%=request.getContextPath()%>/student/acdCourse/absenseApp.do">휴복학 신청</a> 
						<a class="nav-link" href="<%=request.getContextPath()%>/student/acdCourse/subcheck.do">교과목 조회</a> 
						<a class="nav-link" href="<%=request.getContextPath()%>/student/acdCourse/scheduleCheck.do">수강시간표 조회</a>

						<div class="sb-sidenav-menu-heading">출석/성적관리</div>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/atdGrade/attendcheckList.do">출결확인</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/atdGrade/cgradeCheck.do">성적조회</a>

						<div class="sb-sidenav-menu-heading">수강신청</div>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/corReg/corReg.do">수강신청</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/corReg/cAppCheck.do">수강신청 현황조회</a>

						<div class="sb-sidenav-menu-heading">마이페이지</div>
						<a class="nav-link" href="<%=request.getContextPath()%>/student/mypage/myInfoModify.do">비밀번호 변경</a>
					</div>
				</div>
			</nav>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">성적조회</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">출석/성적관리</li>
						<li class="breadcrumb-item active">성적조회</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">성적 조회</div>
						<div class="card-body">

							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<div class="datatable-container">
									<!-- 테이블 -->
									<table class="datatable-table viewtable checktable">
										<thead>
											<tr>
												<th>구분</th>
												<th>학과/학부</th>
												<th>학번</th>
												<th>이름</th>
												<th>학적상황</th>
												<th>지도교수</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>학부</td>
												<td>화학공학과</td>
												<td>200000000</td>
												<td>홍길동</td>
												<td>3학년 휴학</td>
												<td>김교수</td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="datatable-top">

									<div class="right">
										<form action="noticeList.do" method="get"
											class="datatable-search inline">
											<select class="datatable-selector">
												<option value="1" selected>2024</option>
												<option value="2">2023</option>
											</select> <select class="datatable-selector">
												<option value="1" selected>1학기</option>
												<option value="2">2학기</option>
											</select>
											<button class="btn btn-primary inline grey">조회</button>
										</form>
									</div>
								</div>

								<div class="datatable-container">

									<table class="datatable-table viewtable checktable">
										<thead>
											<tr>
												<th colspan="5">00학년도 00학기</th>
											</tr>
											<tr>
												<th>과목명</th>
												<th>개설학과</th>
												<th>이수구분</th>
												<th>학점</th>
												<th>성적</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
											<tr>
												<td>공학설계입문</td>
												<td>화학공학과</td>
												<td>기필</td>
												<td>3</td>
												<td>A</td>
											</tr>
										</tbody>
									</table>

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