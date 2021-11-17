DROP TABLE MEMBER;
CREATE TABLE MEMBER(
	memId VARCHAR(10) PRIMARY KEY,
	memPw VARCHAR(10) not null,
	memMail VARCHAR(20) not null,
	memPhone1 VARCHAR(3),
	memPhone2 VARCHAR(4),
	memPhone3 VARCHAR(4)
);
SELECT * FROM MEMBER;


DROP TABLE BOARD;
CREATE TABLE BOARD(
	bno number(5) not null,
	btitle VARCHAR2(200) not null,
	btext VARCHAR2(4000) not null,
	bid VARCHAR2(20),
	bdate DATE default SYSDATE,
	bcnt number(3) default 0,
	bfile VARCHAR2(20)
);
Insert into board values (1, '첫 게시물입니다.', '안녕하세요.', 'abc', sysdate, 0, null);
SELECT * FROM BOARD ORDER BY BNO DESC;

DROP TABLE EXHIBITION;
CREATE TABLE EXHIBITION (
LATCLICK VARCHAR2(100), /*위도*/
LNGCLICK VARCHAR2(100), /*경도*/
ADDRESS VARCHAR2(100), /*주소*/
NAME VARCHAR2(100),  /*장소명*/
SUBJECT VARCHAR2(100), /*진행 중 전시회*/
PERIODDATE VARCHAR2(100), /*전시기간*/
PERIODTIME VARCHAR2(100), /*영업시간*/
DAYOFF VARCHAR2(100), /*휴무일*/
FARE VARCHAR2(100), /*요금*/
FAREPLACE VARCHAR2(100), /*티켓구매처*/
WEBSITE VARCHAR2(100), /* 하이퍼링크용 웹사이트 */
PHONE VARCHAR2(100), /*연락처*/
METRO VARCHAR2(100), /*지하철*/
THUMBNAIL VARCHAR2(1000) /*imgContent*/
);

INSERT INTO EXHIBITION VALUES('37.5513020159023', '127.04541764031839', '서울 성동구 왕십리로 16가길 30-3', '공장갤러리', '클리웅 :MASK', '2021.10.15.~ 2021.11.15.', '평일 10:00 - 18:00 주말 11:00 - 18:00', '매주 월요일', '무료', '', 'http://blog.naver.com/gongjang_gallery', '02-6953-0210', '2호선 뚝섬역 1번 출구에서 466m', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200106_230%2F1578279690446LQBqB_JPEG%2FwsY-8xhM_P4VOcfGwkcqiNH-.jpg');
INSERT INTO EXHIBITION VALUES('37.57989393549498', '126.98408938234574','서울시 종로구 가회동 북촌로 31-14','원앤제이 갤러리','한진 : 벡사시옹','2021.10.08.~ 2021.11.07.','11:00 ~ 18:00','매주 월요일','무료','','http://www.oneandj.com/','02-745-1644','3호선 안국역 2번 출구에서 381m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190411_245%2F15549614083197CSP0_JPEG%2FDbFQgTY5C4tigSkoO9uSsUzT.jpg');
INSERT INTO EXHIBITION VALUES('37.538589527135436', '127.00146402652385','서울시 용산구 한남동 이태원로 267','페이스 갤러리','알렉산더 칼더 개인전','2021.10.05.~ 2021.11.20.','10:00 ~ 18:00','매주 일요일, 월요일, 공휴일','무료','','http://www.pacegallery.com/','02-790-9388','6호선 한강진역 1번 출구에서 185m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20211013_84%2F1634092070659n708I_JPEG%2FO_-y9apNTGHfmDSfsH1HwcbN.jpg');
INSERT INTO EXHIBITION VALUES('37.536958108175284', '127.01271259768787','서울시 용산구 한남동 독서당로 122-1','타데우스 로팍 서울','게오르그 바젤리츠 : 가르니 호텔','2021.10.07.~ 2021.11.27.','평일 10:00 ~ 18:00','매주 일요일, 월요일','무료','','https://ropac.net','0507-1444-1760','3호선 옥수역 3번 출구에서 1054m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210827_95%2F1630042817680CpdmI_JPEG%2FWhWv4OraiGLFM9mzKkYBPPJF.jpg');
INSERT INTO EXHIBITION VALUES('37.579568720094166','126.98031861099778','서울시 종로구 삼청로 30','국립현대미술관 서울','','','10:00 ~ 18:00','매주 월요일','','','http://www.mmca.go.kr/','02-3701-9500','3호선 안국역 1번 출구에서 759m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210812_207%2F1628777020866yKYPj_JPEG%2Fupload_e7b7e8606d665a9f709a047e6292833b.jpg');
INSERT INTO EXHIBITION VALUES('37.56436972854458', '126.9816082826122','서울시 중구 남대문로 73','그라운드시소 명동','블루룸','2021.06.04.~ 2021.11.28.','11:00 ~ 20:00','롯데백화점 본점 에비뉴엘 정기 휴점일','성인 15,000원 아동/청소년 12,000원','','https://www.instagram.com/groundseesaw','02-1522-1796','2호선 을지로입구역 7번 출구에서 178m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210609_18%2F16232177573233NJxS_JPEG%2Fmv5lR7YYYcuLo1FoLxKQ7Q0T.jpg');
INSERT INTO EXHIBITION VALUES('37.55714580056082 ','126.97803787449186','서울시 중구 남창동 194','피크닉','10 YEARS OF ARCHIVE, DOCUMENTED BY MAGAZINE B','2021.11.10.~ 2021.11.30.','10:00 ~ 18:00','매주 월요일','15,000원','','http://www.piknic.kr','02-318-3233','4호선 회현역 3번 출구에서 162m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210426_3%2F16194032344509LYui_JPEG%2F7r6W4scER4HlYpxNWu7FtX6V.jpg');
INSERT INTO EXHIBITION VALUES('37.57073028717301',' 126.9705244821614','서울시 종로구 새문안로 55','서울역사박물관','다시 일상을 꿈꾸며-역사 속에서 보는 감염병 극복의 희망',
'2021.09.02.~ 2021.11.07.',
'10:00 ~ 18:00',
'공휴일을 제외한 매주 월요일',
'무료',
'',
'https://museum.seoul.go.kr/',
'02-724-0274','5호선 광화문역 7번 출구에서 450m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200514_147%2F1589436241937q3Wgm_JPEG%2F7bcZB4fLD7-rjHNih5yrPv0S.jpg');

INSERT INTO EXHIBITION VALUES('37.481434631833174', '127.01097152808828',
'서울시 서초구 남부순환로 2406','예술의전당 한가람미술관','2021마니프서울국제아트페어','2021.10.31.~ 2021.11.13.','10:00 ~ 19:00','매주 월요일','성인 8,000원 어린이 7,000원','','https://www.sac.or.kr/','02-580-1300','3호선 남부터미널역 5번 출구에서 696m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_156%2F1441007000182w9jAC_JPEG%2F11621559_0.jpg');
INSERT INTO EXHIBITION VALUES('37.54590613661096', '127.04242499740417',
'서울시 성동구 서울숲2길 32-14',
'갤러리아 포레 더서울라이티움',
'아트 오브 뱅크시 [The Art of Banksy - Without Limits]',
'2021.08.20. ~ 2022.02.06.',
'11:00 ~ 20:00 (일요일 ~ 수요일)
11:00 ~ 22:00 (목요일 ~ 토요일/공휴일)',
'매일 운영',
'20,000원',
'',
'https://www.theartofbanksy.asia/',
'02-516-2513','수인분당선 서울숲역 4번 출구에서 194m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190721_93%2F15637028860961utES_JPEG%2FvgYSB7Bs5E7CZ9VYzaZ-vUsg.jpeg.jpg');

select * from EXHIBITION;

COMMIT