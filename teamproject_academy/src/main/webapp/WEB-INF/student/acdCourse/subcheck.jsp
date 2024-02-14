<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 조회</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<%@ include file="/resources/student/include/navHead.jsp" %>
	
	<div id="layoutSidenav">
<%@ include file="/resources/student/include/navLeft.jsp" %>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">교과목 조회</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">학적/수강관리</li>
						<li class="breadcrumb-item active">교과목 조회</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">교과목 조회</div>
						<div class="card-body">
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">

								<div class="datatable-top">

									<div class="right">
										<form action="noticeList.do" method="get" class="datatable-search inline">
											<select class="datatable-selector">
												<option value="1" selected>2024</option>
												<option value="2">2023</option>
											</select> 
											<select class="datatable-selector">
												<option value="1" selected>1학기</option>
												<option value="2">2학기</option>
											</select>
											<button class="btn btn-primary inline grey">검색</button>
										</form>
									</div>
								</div>

								<div class="datatable-container">
									<table class="datatable-table">
										<thead>
											<tr>
												<th>번호</th>
												<th>과목명</th>
												<th>교수명</th>
												<th>시간표</th>
												<th>강의실</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="course" items="${courseList}">
											<tr>
												<td>${course.cno}</td>
												<td><a href="curriculum?lno=${course.lno }">${course.lname }</a></td>
												<td>${course.pname }</td>
												<td>${course.lname }</td>
												<td>${course.lroom }</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</div>
					</div>
				</div>
			</main>
<%@ include file="/resources/student/include/footer.jsp" %>
		</div>
	</div>
</body>
</html>