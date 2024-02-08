<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성페이지</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/styles.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/share/css/summernote/summernote-lite.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/resources/share/js/jquery-3.7.1.min.js"></script>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/resources/share/js/summernote/summernote-lite.js"></script>
<script src="<%=request.getContextPath()%>/resources/share/js/summernote/lang/summernote-ko-KR.js"></script>
<style>
.mright {
	margin-right: 10px;
	margin-top: 10px;
}
</style>
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
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doacdCourse/sscheck.do">학적사항
							조회</a> <a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doacdCourse/absenseApp.do">휴복학
							신청</a> <a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doacdCourse/subcheck.do">교과목
							조회</a> <a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doacdCourse/scheduleCheck.do">수강시간표
							조회</a>

						<div class="sb-sidenav-menu-heading">출석/성적관리</div>
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doatdGrade/attendcheckList.do">출결확인</a>
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.doatdGrade/cgradeCheck.do">성적조회</a>

						<div class="sb-sidenav-menu-heading">수강신청</div>
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.docorReg/corReg.do">수강신청</a>
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.docorReg/cAppCheck.do">수강신청
							현황조회</a>

						<div class="sb-sidenav-menu-heading">마이페이지</div>
						<a class="nav-link"
							href="<%=request.getContextPath()%>/student/stuMain.domypage/myInfoModify.do">비밀번호
							변경</a>
					</div>
				</div>
			</nav>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">공지사항</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">공지사항</a></li>
						<li class="breadcrumb-item active">공지사항 상세페이지</li>
					</ol>

					<div class="card mb-4 white">
						<div class="card-header disNone">공지사항</div>
						<div class="card-body">
							<form method="post">
								<textarea id="summernote" name="content"></textarea>
								<button type="button" class="btn btn-primary grey right mright">취소</button>
								<button class="btn btn-primary grey right mright">저장</button>
							</form>
						</div>
					</div>
				</div>
			</main>

			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; 이젠대학교 2023</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#summernote').summernote({codeviewFilter : false, // 코드 보기 필터 비활성화
										codeviewIframeFilter : false, // 코드 보기 iframe 필터 비활성화
										height : 500, // 에디터 높이
										minHeight : null, // 최소 높이
										maxHeight : null, // 최대 높이
										focus : true, // 에디터 로딩 후 포커스 설정
										lang : 'ko-KR', // 언어 설정 (한국어)
										toolbar : [
													[ 'style', [ 'style' ] ], // 글자 스타일 설정 옵션
													[ 'fontsize',[ 'fontsize' ] ], // 글꼴 크기 설정 옵션
													['font',['bold','underline','clear' ] ], // 글자 굵게, 밑줄, 포맷 제거 옵션
													[ 'color', [ 'color' ] ], // 글자 색상 설정 옵션
													[ 'table', [ 'table' ] ], // 테이블 삽입 옵션
													['para',[ 'ul', 'ol','paragraph' ] ], // 문단 스타일, 순서 없는 목록, 순서 있는 목록 옵션
													[ 'height',[ 'height' ] ], // 에디터 높이 조절 옵션
													['insert',[ 'picture','link''video' ] ], // 이미지 삽입, 링크 삽입, 동영상 삽입 옵션
													['view',['codeview','fullscreen','help' ] ], // 코드 보기, 전체 화면, 도움말 옵션
												],
												
												fontSizes : [ '8', '9', '10','11', '12', '14', '16',
														'18', '20', '22', '24','28', '30', '36', '50','72', ], // 글꼴 크기 옵션

												styleTags : [ 'p', // 일반 문단 스타일 옵션
															{
																title : 'Blockquote',
																tag : 'blockquote',
																className : 'blockquote',
																value : 'blockquote',
															}, // 인용구 스타일 옵션
															'pre', // 코드 단락 스타일 옵션
															{
																title : 'code_light',
																tag : 'pre',
																className : 'code_light',
																value : 'pre',
															}, // 밝은 코드 스타일 옵션
															{
																title : 'code_dark',
																tag : 'pre',
																className : 'code_dark',
																value : 'pre',
															}, // 어두운 코드 스타일 옵션
															'h1', 'h2', 'h3', 'h4', 'h5','h6', // 제목 스타일 옵션
															],

												callbacks : {onImageUpload : 
														function(files, editor,welEditable) {
															// 파일 업로드 (다중 업로드를 위해 반복문 사용)
															for (var i = files.length - 1; i >= 0; i--) {
																var fileName = files[i].name
	
																// 이미지 alt 속성 삽일을 위한 설정
																var caption = prompt('이미지 설명 :',fileName)
																if (caption == '') {
																	caption = '이미지'
																}
																uploadSummernoteImageFile(files[i],this,caption)
														}
													},
												},
											})
		})

		// 이미지 업로드 함수 ajax 활용
		function uploadSummernoteImageFile(file, el, caption) {
			data = new FormData()
			data.append('file', file)
			$.ajax({
				data : data,
				type : 'POST',
				url : 'uploadSummernoteImageFile',
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(data) {
							$(el).summernote('editor.insertImage', data.url,
							function($image) {
							$image.attr('alt', caption) // 캡션 정보를 이미지의 alt 속성에 설정
							})
						},
			})
		}
		
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/share/js/scripts.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/share/js/datatables-simple-demo.js"></script>
</body>
</html>