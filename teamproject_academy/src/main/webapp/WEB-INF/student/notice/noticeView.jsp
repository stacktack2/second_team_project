<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세페이지</title>
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
					<h1 class="mt-4">공지사항</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="noticeList.do">공지사항</a></li>
						<li class="breadcrumb-item active">공지사항 상세페이지</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">공지사항</div>
						<div class="card-body">
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<div class="datatable-container">
									<table class="datatable-table viewtable">
										<tbody>
											<tr>
												<th>제목</th>
												<td colspan="5">공지사항 제목</td>
											</tr>
											<tr>
												<th>작성자</th>
												<td>관리자</td>
												<th>작성일</th>
												<td>2024.02.04</td>
												<th>조회수</th>
												<td>0</td>
											</tr>
											<tr>
												<td colspan="6" style="height: 500px;">본문내용입니다</td>
											</tr>
											<tr>
												<th>첨부파일</th>
												<td colspan="5"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="datatable-bottom">
									<a href="noticeList.do" class="btn btn-primary grey right mright">목록</a>
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
</body>
</html>