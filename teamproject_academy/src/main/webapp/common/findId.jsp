<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<style>
	.bg-primary{
		background-image:url("./img/univ1.jpg");
		background-size: cover;
	}
	.block{display:block;}
	.findIdBtn{margin-left:42%;}
</style>
</head>
<body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">아이디 찾기</h3></div>
                                    <div class="card-body">
                                        <div class="small mb-3 text-muted">
                                        	<span class="block">* 이름과 생년월일과 연락처를 모두 입력한 다음버튼을 눌러주세요</span>
                                        	<span class="block">* 생년월일은 6글자로 입력해주세요 (ex 19990101)</span>
                                       		<span class="block">* 연락처는 -와 공백없이 입력해주세요(ex 01011111111)</span>
                                       </div>
                                        <form>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputName" type="text" placeholder="이름" />
                                                <label for="inputName">이름</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputBirth" type="text" placeholder="생년월일" />
                                                <label for="inputBirth">생년월일</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputPhone" placeholder="연락처" />
                                                <label for="inputPhone">연락처</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="btn btn-primary findIdBtn" href="#">다음</a>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="index.jsp">로그인</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
        <script src="js/scripts.js"></script>
    </body>
</html>