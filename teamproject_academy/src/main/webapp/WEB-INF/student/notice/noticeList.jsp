<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
		<%@ include file="/resources/student/include/navHead.jsp" %>

	<div id="layoutSidenav">
	<%@ include file="/resources/student/include/navLeft.jsp" %>
		<!-- 메인페이지 -->
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">공지사항</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="noticeList.do">공지사항</a></li>
						<li class="breadcrumb-item active">공지사항 목록페이지</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">공지사항</div>
						<div class="card-body">
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<!-- 테이블 탑 -->
								<div class="datatable-top">
									<!-- 셀렉트 -->
									<div class="datatable-dropdown">
										<label> <select class="datatable-selector">
												<option value="1" selected>최신순</option>
												<option value="2">인기순</option>
										</select>
										</label>
									</div>
									<!-- 검색 -->
									<div class="right">
										<select class="datatable-selector">
											<option value="1" selected>제목</option>
											<option value="2">내용</option>
										</select>
										<form action="noticeList.do" method="get"
											class="datatable-search inline">
											<input class="datatable-input inline wauto"
												placeholder="검색어를 입력하세요" type="search"
												title="Search within table" aria-controls="datatablesSimple">
											<button class="btn btn-primary inline grey">검색</button>
										</form>
									</div>
								</div>
								<!-- 테이블 컨테이너 -->
								<div class="datatable-container">
									<!-- 테이블 -->
									<table class="datatable-table">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="board" items="${noticeList}">
											<tr>
												<td>${board.bno }</td>
												<td><a href="noticeView?bno=${board.bno }">${board.btitle }</a></td>
												<td>${board.brdate }</td>
												<td>${board.bhit }</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- 테이블 바텀 -->
							<div class="datatable-bottom">
								<!-- 페이징 -->
								<nav class="datatable-pagination">
									<ul class="datatable-pagination-list">
										<li class="datatable-pagination-list-item datatable-hidden datatable-disabled">
											<a data-page="1" class="datatable-pagination-list-item-link">‹</a>
										</li>
										<li class="datatable-pagination-list-item datatable-active">
											<a data-page="1" class="datatable-pagination-list-item-link">1</a>
										</li>
										<li class="datatable-pagination-list-item">
											<a data-page="2" class="datatable-pagination-list-item-link">2</a>
										</li>
										<li class="datatable-pagination-list-item">
											<a data-page="2" class="datatable-pagination-list-item-link">›</a>
										</li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</main>
<%@ include file="/resources/student/include/footer.jsp" %>
		</div>
	</div>

</body>
</body>
</html>