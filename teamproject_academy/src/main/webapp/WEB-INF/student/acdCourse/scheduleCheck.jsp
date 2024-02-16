<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강시간표 조회</title>
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
					<h1 class="mt-4">수강시간표</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">학적/수강관리</li>
						<li class="breadcrumb-item active">수강시간표</li>
					</ol>

					<div class="card mb-4">
						<div class="card-header disNone">수강시간표</div>
						<div class="card-body">

							<div class="card mb-4 white">
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
							<div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">

								<div class="datatable-container">
									<table class="datatable-table viewtable checktable timetable">
										<thead>
											<tr>
												<th style="width: 5%;">교시</th>
												<th>월</th>
												<th>화</th>
												<th>수</th>
												<th>목</th>
												<th>금</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>0</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>1</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>2</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>3</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>4</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>5</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</tbody>
									</table>

								</div>
								<div class="card mb-4 white">
									<table class="datatable-table viewtable checktable">
										<tr>
											<td>0교시(08:00 ~ 08:50)</td>
											<td>1교시(09:00 ~ 10:15)</td>
											<td>2교시(10:30 ~ 11:45)</td>
											<td>3교시(12:00 ~ 13:15)</td>
										</tr>
										<tr>
											<td>4교시(13:30 ~ 14:45)</td>
											<td>5교시(15:00 ~ 16:15)</td>
											<td>6교시(16:30 ~ 17:45)</td>
											<td>7교시(18:00 ~ 18:45)</td>
										</tr>
										<tr>
											<td>8교시(18:50 ~ 19:35)</td>
											<td>9교시(19:40 ~ 20:25)</td>
											<td>10교시(20:30 ~ 21:15)</td>
											<td>11교시(21:20 ~ 22:05)</td>
										</tr>
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