<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석관리</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>



<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
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
					<h1 class="mt-4">출석 관리</h1>
					<div class="card mb-4 white">
						<div class="card-header disNone">출석 관리</div>
						<div class="card-body">
							<div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
							
								<!-- 테이블 탑 -->
								<div class="datatable-top">
									<!-- 검색- 날짜 api 활용 -->
									<div class="right">
										<form action="noticeList" method="get" class="datatable-search inline">
											<input type="text" name="attendday" />
											<button class="btn btn-primary inline grey">검색</button>
										</form>
									</div>
								</div>
								
								<!-- 테이블 컨테이너 -->
								<div class="datatable-container">
									<!-- 테이블 -->
									<form>
										<table class="datatable-table">
											<thead>
												<tr>
													<th>성명</th>
													<th>학번</th>
													<th>전화번호</th>
													<th>출결</th>
													<th>관리</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>홍길동</td>
													<td>202029322</td>
													<td>010-2452-2424</td>
													<td>출석</td>
													<td>
														<select class="datatable-selector right">
															<option value="1" selected>출석</option>
															<option value="2">결석</option>
															<option value="2">지각</option>
														</select>	
													</td>
												</tr>
												<tr>
													<td>김길동</td>
													<td>202029322</td>
													<td>010-2452-2424</td>
													<td>출석</td>
													<td>
														<select class="datatable-selector right">
															<option value="1" selected>출석</option>
															<option value="2">결석</option>
															<option value="2">지각</option>
														</select>	
													</td>
												</tr>
											</tbody>
										</table>
										<button class="btn btn-primary inline grey right">저장</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<%@ include file="/resources/admin/include/footer.jsp" %>
		</div>
	</div>
	<!-- 좌측 nav 바~푸터까지 END -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>