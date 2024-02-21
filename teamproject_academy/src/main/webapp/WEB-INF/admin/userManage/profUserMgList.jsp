<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.PagingVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
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
					<h1 class="mt-4">교수 사용자 관리</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">사용자 관리</li>
						<li class="breadcrumb-item active">교수 관리</li>
					</ol>

					<div class="card mb-4 white">
						
						<div class="card-body">
							<div
								class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
								<!-- 테이블 탑 -->
								<div class="datatable-top">
									<!-- 검색 -->
									<div class="right">
										<form name="frm" action="profUserMgList" method="get" class="datatable-search inline">
											<input 
												class="datatable-input inline wauto"
												placeholder="이름을 입력하세요" type="text"
												aria-controls="datatablesSimple" 
												name="searchValue" id="title">
											<button class="btn btn-primary inline grey">검색</button>
										</form>
									</div>
								</div>
								<!-- 테이블 컨테이너 -->
								<div class="datatable-container">
									<!-- 테이블 -->
									<form name="frm" action="profUserMgView" method="post">
									<table class="datatable-table">
										<thead>
											<tr>
												<th><input type="checkbox" name="" id=""></th>
												<th>교수번호</th>
												<th>이름</th>
												<th>직급</th>
												<th>연구실</th>
												<th>연락처</th>
												<th>이메일</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="professor" items="${professorList}">
											<tr>
												<td style="text-align: center">
													<input type="checkbox" name="" id="">
												</td>
												<td>${professor.pid }</td>
												<td>
													<a href="profUserMgView?pno=${professor.pno }" onsubmit="">${professor.pname }</a>
													<input type="hidden" name="pno" value="${professor.pno }">
												</td>
												<td>${professor.pposition }</td>
												<td>${professor.plab }</td>
												<td>${professor.pphone }</td>
												<td>${professor.pemail }</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									</form>
								</div>
							</div>
							<!-- 테이블 바텀 -->
							<div class="datatable-bottom col-12 d-sm-inline-block">
							<div class="datatable-bottom ms-auto ">
								<button class="btn btn-primary inline grey mleft" type="button">삭제</button>
							</div>
								<!-- 페이징 -->
								<nav class="datatable-pagination" style="display: inline-block; margin-top: 0.75rem; margin-left: 32rem;">
								    <ul class="datatable-pagination-list">
								        <c:if test="${pagingVO.startPage > 1 }">
								            <li class="datatable-pagination-list-item">
								                <a class="datatable-pagination-list-item-link"
								                   href="<%=request.getContextPath()%>/admin/userManage/profUserMgList?nowPage=${pagingVO.startPage - 1}">‹</a>
								            </li>
								        </c:if>
								
								        <c:forEach begin="${pagingVO.startPage}" end="${pagingVO.endPage}" var="page">
								            <c:choose>
								                <c:when test="${page eq pagingVO.nowPage}">
								                    <li class="datatable-pagination-list-item datatable-active">
								                        <a data-page="${page}" class="datatable-pagination-list-item-link">${page}</a>
								                    </li>
								                </c:when>
								                <c:otherwise>
								                    <li class="datatable-pagination-list-item">
								                        <a href="<%=request.getContextPath()%>/admin/userManage/profUserMgList?nowPage=${page}"
								                           class="datatable-pagination-list-item-link">${page}</a>
								                    </li>
								                </c:otherwise>
								            </c:choose>
								        </c:forEach>
								
								        <c:if test="${pagingVO.endPage < pagingVO.lastPage}">
								            <li class="datatable-pagination-list-item">
								                <a href="<%=request.getContextPath()%>/admin/userManage/profUserMgList?nowPage=${pagingVO.endPage + 1}"
								                   class="datatable-pagination-list-item-link">›</a>
								            </li>
								        </c:if>
								    </ul>
								</nav>

							<div class="datatable-bottom ms-auto">
									<a href="profUserAdd" class="btn btn-primary grey right mright">사용자 추가</a>
							</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<%@ include file="/resources/admin/include/footer.jsp" %>
		</div>
        </div>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    </body>
</html>