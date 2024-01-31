SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS boardFile;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS administer;
DROP TABLE IF EXISTS attendment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS lecture;
DROP TABLE IF EXISTS professorFile;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS studentFile;
DROP TABLE IF EXISTS student;




/* Create Tables */

-- 관리자정보
CREATE TABLE administer
(
	ano int unsigned NOT NULL AUTO_INCREMENT COMMENT '관리자번호',
	aid varchar(20) NOT NULL COMMENT '관리자 아이디',
	apw varchar(20) NOT NULL COMMENT '관리자 비밀번호',
	ardate date DEFAULT (current_date) NOT NULL COMMENT '관리자 가입일',
	amanage tinyint unsigned DEFAULT 1 NOT NULL COMMENT '관리자 관리권한',
	adelyn tinyint unsigned DEFAULT 0 NOT NULL COMMENT '관리자 탈퇴여부',
	PRIMARY KEY (ano)
) COMMENT = '관리자정보';


-- 출석정보
CREATE TABLE attendment
(
	attendno int unsigned NOT NULL AUTO_INCREMENT COMMENT '출석번호',
	attendrdate date COMMENT '출석일',
	attendyn tinyint unsigned COMMENT '출석여부',
	cno int unsigned NOT NULL COMMENT '수강번호',
	PRIMARY KEY (attendno)
) COMMENT = '출석정보';


-- 게시물
CREATE TABLE board
(
	bno int unsigned NOT NULL AUTO_INCREMENT COMMENT '게시물 번호',
	btitle varchar(50) NOT NULL COMMENT '제목',
	bcontent text NOT NULL COMMENT '내용',
	brdate date DEFAULT (current_date) NOT NULL COMMENT '작성일자',
	bhit int unsigned DEFAULT 0 NOT NULL COMMENT '조회수',
	bdelyn tinyint unsigned DEFAULT 0 NOT NULL COMMENT '삭제여부',
	ano int unsigned NOT NULL COMMENT '관리자번호',
	PRIMARY KEY (bno)
) COMMENT = '게시물';


-- 게시글 첨부파일
CREATE TABLE boardFile
(
	bfno int unsigned NOT NULL AUTO_INCREMENT COMMENT '파일번호',
	bfrealnm varchar(255) NOT NULL COMMENT '실제파일이름',
	bforiginnm varchar(255) NOT NULL COMMENT '원본파일이름',
	bfrdate date DEFAULT (current_date) NOT NULL COMMENT '파일등록일',
	bno int unsigned NOT NULL COMMENT '게시물 번호',
	PRIMARY KEY (bfno)
) COMMENT = '게시글 첨부파일';


-- 수강정보
CREATE TABLE course
(
	cno int unsigned NOT NULL AUTO_INCREMENT COMMENT '수강번호',
	cyn tinyint unsigned DEFAULT 0 NOT NULL COMMENT '수강여부',
	cgrade varchar(2) COMMENT '성적',
	lno int unsigned NOT NULL COMMENT '강의번호',
	sno int unsigned NOT NULL COMMENT '학생번호',
	PRIMARY KEY (cno)
) COMMENT = '수강정보';


-- 강의정보
CREATE TABLE lecture
(
	lno int unsigned NOT NULL AUTO_INCREMENT COMMENT '강의번호',
	lname varchar(40) NOT NULL COMMENT '강의명',
	lyear date NOT NULL COMMENT '강의년도',
	lsemester tinyint unsigned NOT NULL COMMENT '강의학기',
	lcredit tinyint unsigned NOT NULL COMMENT '학점',
	ltime tinyint unsigned NOT NULL COMMENT '강의시간',
	lroom varchar(10) NOT NULL COMMENT '강의실',
	lmaxpeople varchar(5) NOT NULL COMMENT '수강최대인원',
	lintro text NOT NULL COMMENT '교과목 개요',
	lfocus text NOT NULL COMMENT '강의목표',
	lstatus tinyint unsigned DEFAULT 0 NOT NULL COMMENT '강의상태',
	pno int unsigned NOT NULL COMMENT '교수번호',
	PRIMARY KEY (lno)
) COMMENT = '강의정보';


-- 교수정보
CREATE TABLE professor
(
	pno int unsigned NOT NULL AUTO_INCREMENT COMMENT '교수번호',
	pid varchar(20) NOT NULL COMMENT '아이디',
	ppw varchar(20) NOT NULL COMMENT '비밀번호',
	pname varchar(20) NOT NULL COMMENT '이름',
	pregNo1 char(6) NOT NULL COMMENT '주민번호 앞자리',
	pregNo2 char(7) NOT NULL COMMENT '주민번호 뒷자리',
	pbirth date NOT NULL COMMENT '생년월일',
	pgender varchar(2) NOT NULL COMMENT '성별',
	pemail varchar(45) NOT NULL COMMENT '이메일',
	pphone varchar(20) NOT NULL COMMENT '휴대전화번호',
	pcall varchar(20) COMMENT '집전화번호',
	paddr varchar(45) NOT NULL COMMENT '주소',
	pzipCode varchar(10) COMMENT '우편번호',
	prdate date DEFAULT (current_date) NOT NULL COMMENT '가입일',
	pposition varchar(20) NOT NULL COMMENT '직급',
	puniv varchar(40) NOT NULL COMMENT '대학',
	pfaculty varchar(40) NOT NULL COMMENT '학부',
	pmajor varchar(40) NOT NULL COMMENT '전공',
	pdegree varchar(40) NOT NULL COMMENT '학위',
	plab varchar(40) NOT NULL COMMENT '연구실',
	pappointDate date NOT NULL COMMENT '임용일자',
	pdelyn tinyint unsigned DEFAULT 0 NOT NULL COMMENT '탈퇴여부',
	PRIMARY KEY (pno)
) COMMENT = '교수정보';


-- 교수 사진파일
CREATE TABLE professorFile
(
	pfno int unsigned NOT NULL AUTO_INCREMENT COMMENT '파일번호',
	pfrealnm varchar(255) NOT NULL COMMENT '실제파일이름',
	pforiginnm varchar(255) NOT NULL COMMENT '원본파일이름',
	pfrdate date DEFAULT (current_date) NOT NULL COMMENT '파일등록일',
	pno int unsigned NOT NULL COMMENT '교수번호',
	PRIMARY KEY (pfno)
) COMMENT = '교수 사진파일';


-- 학생정보
CREATE TABLE student
(
	sno int unsigned NOT NULL AUTO_INCREMENT COMMENT '학생번호',
	sid varchar(20) NOT NULL COMMENT '아이디',
	spw varchar(20) NOT NULL COMMENT '비밀번호',
	sname varchar(20) NOT NULL COMMENT '이름',
	sregNo1 char(6) NOT NULL COMMENT '주민번호 앞자리',
	sregNo2 char(7) NOT NULL COMMENT '주민번호 뒷자리',
	sbirth date NOT NULL COMMENT '생년월일',
	sgender varchar(2) NOT NULL COMMENT '성별',
	semail varchar(45) NOT NULL COMMENT '이메일',
	sphone varchar(20) NOT NULL COMMENT '휴대전화번호',
	scall varchar(20) COMMENT '집전화번호',
	saddr varchar(45) NOT NULL COMMENT '주소',
	szipCode varchar(10) COMMENT '우편번호',
	srdate date DEFAULT (current_date) NOT NULL COMMENT '가입일',
	sstatus tinyint unsigned NOT NULL COMMENT '학적상태',
	suniv varchar(40) NOT NULL COMMENT '대학',
	sfaculty varchar(40) NOT NULL COMMENT '학부',
	smajor varchar(40) NOT NULL COMMENT '전공',
	sgrade tinyint unsigned NOT NULL COMMENT '학년',
	srank int unsigned NOT NULL COMMENT '학과석차',
	scomeDate date NOT NULL COMMENT '입학일자',
	soutDate date COMMENT '제적일자',
	scompletionDate date COMMENT '수료일자',
	sgradDate date COMMENT '졸업일자',
	smaxgrade tinyint unsigned NOT NULL COMMENT '학기최대이수학점',
	sdelyn tinyint unsigned DEFAULT 0 NOT NULL COMMENT '탈퇴여부',
	PRIMARY KEY (sno)
) COMMENT = '학생정보';


-- 학생 사진파일
CREATE TABLE studentFile
(
	sfno int unsigned NOT NULL AUTO_INCREMENT COMMENT '파일번호',
	sfrealnm varchar(255) NOT NULL COMMENT '실제파일이름',
	sforiginnm varchar(255) NOT NULL COMMENT '원본파일이름',
	sfrdate date DEFAULT (current_date) NOT NULL COMMENT '파일등록일',
	sno int unsigned NOT NULL COMMENT '학생번호',
	PRIMARY KEY (sfno)
) COMMENT = '학생 사진파일';



/* Create Foreign Keys */

ALTER TABLE board
	ADD FOREIGN KEY (ano)
	REFERENCES administer (ano)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE boardFile
	ADD FOREIGN KEY (bno)
	REFERENCES board (bno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE attendment
	ADD FOREIGN KEY (cno)
	REFERENCES course (cno)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE course
	ADD FOREIGN KEY (lno)
	REFERENCES lecture (lno)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE lecture
	ADD FOREIGN KEY (pno)
	REFERENCES professor (pno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE professorFile
	ADD FOREIGN KEY (pno)
	REFERENCES professor (pno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE course
	ADD FOREIGN KEY (sno)
	REFERENCES student (sno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE studentFile
	ADD FOREIGN KEY (sno)
	REFERENCES student (sno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



