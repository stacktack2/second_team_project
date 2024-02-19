<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/admin/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <!-- 상단 nav 바 -->
    <%@ include file="/resources/admin/include/navHead.jsp" %>
    <div id="layoutSidenav">
    <!-- 좌측 nav 바 -->
    <%@ include file="/resources/admin/include/navLeft.jsp" %>
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
						<div class="card mb-4" style="width: 247px; height: 292px;" id="photoPreview">
							<!-- <img > -->
					</div>
						<input type="file" id="photoInput" onchange="displayPhotoPreview(event)" style="display: none;">
						<label class="btn btn-primary inline grey mb-4" for="photoInput">사진 추가</label>
						<!-- <button class="btn btn-primary inline grey mb-4" type="button" onclick="uploadPhoto()">사진 추가</button> -->
					
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
											<input type="hidden" name="ppw" id="ppw">
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
											<input type="radio" name="pgender" id="pgender" value="M" 
												   class="form-check-input d-inline-block mx-3 me-xxl-2" >
											<span class="inputSpan">남</span>
											<input type="radio" name="pgender" id="pgender" value="W" 
												   class="form-check-input d-inline-block mx-3 me-xxl-2" >
										    <span class="inputSpan">여</span>
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
										<th>연구실 전화번호</th>
										<td>
											<input type="text" name="pcall" id="pcall" class="datatable-input">
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td colspan="3">
											<input type="text" name="paddr" id="paddr" class="datatable-input" style="display: inline-block; width: 89%;">
											<input type="button" onclick="sample6_execDaumPostcode()" value="주소 검색">
										</td>
										<th>우편번호</th>
										<td>
											<input type="text" name="pzipcode" id="pzipcode" class="datatable-input d-inline-block">
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
		<%@ include file="/resources/admin/include/footer.jsp" %>
	</div>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <!-- 첨부파일 js -->
    <!-- <script src="/resources/admin/js/profUserAddPhoto.js"></script> -->
    </body>
</html>