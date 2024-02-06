<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴복학 신청</title>
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
					<h1 class="mt-4">휴복학 신청</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">학적/수강관리</li>
						<li class="breadcrumb-item active">휴복학 신청</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">휴복학 신청</div>
						<div class="card-body">
							<table class="datatable-table viewtable checktable"
								style="width: 20%;">
								<tbody>
									<tr>
										<th>학적상태</th>
										<td>휴학</td>
									</tr>
								</tbody>
							</table>

							<div class="card mb-4">
								<div class="card-body">
									<h6 class="bold">휴복학 신청에 대한 규정 및 설명</h6>
									<!--                              	<p>* 일반휴학</p>
                            	<p> - 가정형편 등 불가피한 사유로 학업을 계속할 수 없는 경우 당해 학기 수업일수의 1/3이내에 소속 학과장을 경유 휴학신청서를 제출하여 총장의 허가를 받아야 함.</p>
                            	<p>* 질병휴학</p>
                            	<p> - 학기 중 장기치료를 요하는 질병으로 휴학하고자 하는 학생은 소정양식의 일반 휴학원을 작성한 후 의사의 진단서를 첨부하여야 함.</p>
                            	<p>* 군입대 휴학</p>
                            	<p> - 입영통지서에 의하여 군에 입대하여야 하는 학생은 군입대 전까지 휴학신청서(입영통지서 사본 필수 첨부)를 제출하여 총장의 허가를 얻어야 함.</p>
                            	<p> - 군입대 휴학 절차를 밟지 않은 학생은 제적처리 되며, 일반휴학 기간 중에 군에 입대하는 경우, 휴학변경신청서(입영통지서 필수 포함)를 제출하여 총장의 허가를 얻어야 함.</p>
                            	<p> - 군입대 휴학한 학생이 입영과 동시에 귀가 조치되었을 때는 귀가 조치 후 5일 이내에 교학처에 신고하여야 함.</p>
                            	<p></p>
-->
									<p>* 휴학기간</p>
									<p>- 일반휴학은 1년 또는 학기 단위로 실시하며, 통산하여 6학기를 초과할 수 없다.</p>
									<p>- 휴학기간을 연장하고자 할 때에는 휴학기간 만료 7일전까지 휴학 연장원을 제출하여 총장의 허가를
										받아야 함.</p>
									<p>* 신(편)입생의 휴학</p>
									<p>- 신(편)입생에게는 입학이후 1년간 휴학을 허가하지 아니한다. 다만, 법령에 의한 의무이행,
										임신.출산.육아, 질병, 대학원생, 기타 부득이한 사유로 인하여 수학할 수 없는 경우는 예외로 한다.</p>
									<p>* 복학</p>
									<p>- 복학은 매 학기 등록기간 내에 소정의 복학신청서를 제출해야 하며, 수업일수 1/3이상 경과 되었을
										때에는 복학을 허가하지 아니함.</p>
									<p>- 군입대 후 전역예정자인 경우, 수업일수 2/3이상 출석이 가능함을 입증하는 서류(휴가증, 전역예정
										증명서, 부대장의 복학추천서 등)를 첨부하여 제출하면 복학을 허가함.</p>
									<p>- 1학년 재학생(2개학기 이하 이수자)은 역학기 복학을 할 수 없음.</p>
									<p></p>
									<p>&#10003; 관련규정</p>
									<p>- 학칙 제47조, 제48조, 학사운영규정 제18조, 제19조, 제20조, 제21조</p>
								</div>
							</div>
							<h3>신청 내역</h3>
							<table class="datatable-table viewtable checktable">
								<thead>
									<tr>
										<th>신청구분</th>
										<th>신청일자</th>
										<th>처리상태</th>
										<th>처리일자</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>일반휴학</td>
										<td>2022-02-20</td>
										<td>처리완료</td>
										<td>2022-02-21</td>
									</tr>
									<tr>
										<td>일반휴학</td>
										<td>2022-02-20</td>
										<td>처리완료</td>
										<td>2022-02-21</td>
									</tr>
									<tr>
										<td>일반휴학</td>
										<td>2022-02-20</td>
										<td>처리완료</td>
										<td>2022-02-21</td>
									</tr>
									<tr>
										<td>일반휴학</td>
										<td>2022-02-20</td>
										<td>처리완료</td>
										<td>2022-02-21</td>
									</tr>
								</tbody>
							</table>
							<button class="btn btn-primary inline grey">휴학신청</button>
							<button class="btn btn-primary inline grey">복학신청</button>
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