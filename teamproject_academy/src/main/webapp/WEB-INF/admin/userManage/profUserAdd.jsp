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
            
            
            <!-- 메인페이지 -->
            <div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">교수 사용자 추가</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">사용자 관리</li>
						<li class="breadcrumb-item active">교수 관리</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">교수 사용자 추가</div>
						<!-- 사진 첨부파일 -->
						<div class="card-body">
							<div class="card mb-4 w-25 h-50">
								<img id="photoPreview" style="max-width: 150px; max-height: 150px;">
							</div>
						<!-- <button class="btn btn-primary inline grey mb-4" type="button" onclick="uploadPhoto()">사진 추가</button> -->
						<input type="file" id="photoInput" accept="image/*" onchange="displayPhotoPreview(this)"><!-- style="display: none;" -->
						<label class="btn btn-primary inline grey mb-4" for="photoInput">사진 추가</label>
						
						<!-- 인적사항 -->
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<div class="datatable-container">
									<!-- 인적사항 정보 테이블 -->
									<form name="frm" action="profUserAdd" method="post">
									<table class="datatable-table viewtable sschecktable">
										<tbody>
											<tr>
												<th>교번</th>
												<td style="width: 20rem;">
													<input type="text" name="pid" id="pid" class="datatable-input">
												</td>
												<th>성명</th>
												<td style="width: 20rem;">
													<input type="text" name="pname" id="pname" class="datatable-input">
												</td>
												<th>주민번호</th>
												<td>
													<input type="text" name="pregNo1" id="pregNo1" class="datatable-input d-inline-block" style="width: 45%;">
													<a style="margin: 0 0.9rem;">-</a> 
													<input type="text" name="pregNo2" id="pregNo2" class="datatable-input d-inline-block" style="width: 45%;">
												</td>
											</tr>
											<tr>
												<th>생년월일</th>
												<td>
													<input type="text" name="pbirth" id="pbirth" class="datatable-input">
												</td>
												<th>성별</th>
												<td>
													<input type="radio" name="pgender" id="pgender" value="M" class="form-check-input d-inline-block" >남
													<input type="radio" name="pgender" id="pgender" value="W" class="form-check-input d-inline-block" >여
												</td>
												<th>직급</th>
												<td>
													<input type="text" name="pposition" id="pposition" class="datatable-input">
												</td>
											</tr>
											<tr>
												<th>대학</th>
												<td>
													<input type="text" name="puniv" id="puniv" class="datatable-input">
												</td>
												<th>학부</th>
												<td>
													<input type="text" name="pfaculty" id="pfaculty" class="datatable-input">
												</td>
												<th>전공</th>
												<td>
													<input type="text" name="pmajor" id="pmajor" class="datatable-input">
												</td>
											</tr>
											<tr>
												<th>학위</th>
												<td>
													<input type="text" name="pdegree" id="pdegree" class="datatable-input">
												</td>
												<th>연구실</th>
												<td>
													<input type="text" name="plab" id="plab" class="datatable-input">
												</td>
												<th>임용일자</th>
												<td>
													<input type="text" name="pappointDate" id="pappointDate" class="datatable-input">
												</td>
											</tr>
											<tr>
												<th>E-mail</th>
												<td>
													<input type="text" name="pemail" id="pemail" class="datatable-input">
												</td>
												<th>휴대전화번호</th>
												<td>
													<input type="text" name="pphone" id="pphone" class="datatable-input">
												</td>
												<th>집전화번호</th>
												<td>
													<input type="text" name="pcall" id="pcall" class="datatable-input">
												</td>
											</tr>
											<tr>
												<th>주소</th>
												<td colspan="3">
													<input type="text" name="paddr" id="paddr" class="datatable-input">
												</td>
												<th>우편번호</th>
												<td>
													<input type="text" name="pzipcode" id="pzipcode" class="datatable-input">
												</td>

											</tr>
										</tbody>
									</table>
									</form>
								</div>
							</div>
							<!-- 테이블 바텀 -->
							<div class="datatable-bottom ms-auto">
									<a href="profUserMgView" class="btn btn-primary grey right mright">등록</a>
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
        <!-- 첨부파일 js -->
        <!-- <script src="/resources/admin/js/profUserAddPhoto.js"></script> -->
    </body>
</html>