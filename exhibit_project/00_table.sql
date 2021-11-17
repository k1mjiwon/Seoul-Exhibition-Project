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
Insert into board values (1, 'ù �Խù��Դϴ�.', '�ȳ��ϼ���.', 'abc', sysdate, 0, null);
SELECT * FROM BOARD ORDER BY BNO DESC;

DROP TABLE EXHIBITION;
CREATE TABLE EXHIBITION (
LATCLICK VARCHAR2(100), /*����*/
LNGCLICK VARCHAR2(100), /*�浵*/
ADDRESS VARCHAR2(100), /*�ּ�*/
NAME VARCHAR2(100),  /*��Ҹ�*/
SUBJECT VARCHAR2(100), /*���� �� ����ȸ*/
PERIODDATE VARCHAR2(100), /*���ñⰣ*/
PERIODTIME VARCHAR2(100), /*�����ð�*/
DAYOFF VARCHAR2(100), /*�޹���*/
FARE VARCHAR2(100), /*���*/
FAREPLACE VARCHAR2(100), /*Ƽ�ϱ���ó*/
WEBSITE VARCHAR2(100), /* �����۸�ũ�� ������Ʈ */
PHONE VARCHAR2(100), /*����ó*/
METRO VARCHAR2(100), /*����ö*/
THUMBNAIL VARCHAR2(1000) /*imgContent*/
);

INSERT INTO EXHIBITION VALUES('37.5513020159023', '127.04541764031839', '���� ������ �սʸ��� 16���� 30-3', '���尶����', 'Ŭ���� :MASK', '2021.10.15.~ 2021.11.15.', '���� 10:00 - 18:00 �ָ� 11:00 - 18:00', '���� ������', '����', '', 'http://blog.naver.com/gongjang_gallery', '02-6953-0210', '2ȣ�� �Ҽ��� 1�� �ⱸ���� 466m', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200106_230%2F1578279690446LQBqB_JPEG%2FwsY-8xhM_P4VOcfGwkcqiNH-.jpg');
INSERT INTO EXHIBITION VALUES('37.57989393549498', '126.98408938234574','����� ���α� ��ȸ�� ���̷� 31-14','�������� ������','���� : ����ÿ�','2021.10.08.~ 2021.11.07.','11:00 ~ 18:00','���� ������','����','','http://www.oneandj.com/','02-745-1644','3ȣ�� �ȱ��� 2�� �ⱸ���� 381m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190411_245%2F15549614083197CSP0_JPEG%2FDbFQgTY5C4tigSkoO9uSsUzT.jpg');
INSERT INTO EXHIBITION VALUES('37.538589527135436', '127.00146402652385','����� ��걸 �ѳ��� ���¿��� 267','���̽� ������','�˷���� Į�� ������','2021.10.05.~ 2021.11.20.','10:00 ~ 18:00','���� �Ͽ���, ������, ������','����','','http://www.pacegallery.com/','02-790-9388','6ȣ�� �Ѱ����� 1�� �ⱸ���� 185m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20211013_84%2F1634092070659n708I_JPEG%2FO_-y9apNTGHfmDSfsH1HwcbN.jpg');
INSERT INTO EXHIBITION VALUES('37.536958108175284', '127.01271259768787','����� ��걸 �ѳ��� ������� 122-1','Ÿ���콺 ���� ����','�Կ����� �������� : ������ ȣ��','2021.10.07.~ 2021.11.27.','���� 10:00 ~ 18:00','���� �Ͽ���, ������','����','','https://ropac.net','0507-1444-1760','3ȣ�� ������ 3�� �ⱸ���� 1054m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210827_95%2F1630042817680CpdmI_JPEG%2FWhWv4OraiGLFM9mzKkYBPPJF.jpg');
INSERT INTO EXHIBITION VALUES('37.579568720094166','126.98031861099778','����� ���α� ��û�� 30','��������̼��� ����','','','10:00 ~ 18:00','���� ������','','','http://www.mmca.go.kr/','02-3701-9500','3ȣ�� �ȱ��� 1�� �ⱸ���� 759m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210812_207%2F1628777020866yKYPj_JPEG%2Fupload_e7b7e8606d665a9f709a047e6292833b.jpg');
INSERT INTO EXHIBITION VALUES('37.56436972854458', '126.9816082826122','����� �߱� ���빮�� 73','�׶���ü� ��','����','2021.06.04.~ 2021.11.28.','11:00 ~ 20:00','�Ե���ȭ�� ���� ���񴺿� ���� ������','���� 15,000�� �Ƶ�/û�ҳ� 12,000��','','https://www.instagram.com/groundseesaw','02-1522-1796','2ȣ�� �������Ա��� 7�� �ⱸ���� 178m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210609_18%2F16232177573233NJxS_JPEG%2Fmv5lR7YYYcuLo1FoLxKQ7Q0T.jpg');
INSERT INTO EXHIBITION VALUES('37.55714580056082 ','126.97803787449186','����� �߱� ��â�� 194','��ũ��','10 YEARS OF ARCHIVE, DOCUMENTED BY MAGAZINE B','2021.11.10.~ 2021.11.30.','10:00 ~ 18:00','���� ������','15,000��','','http://www.piknic.kr','02-318-3233','4ȣ�� ȸ���� 3�� �ⱸ���� 162m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210426_3%2F16194032344509LYui_JPEG%2F7r6W4scER4HlYpxNWu7FtX6V.jpg');
INSERT INTO EXHIBITION VALUES('37.57073028717301',' 126.9705244821614','����� ���α� �����ȷ� 55','���￪��ڹ���','�ٽ� �ϻ��� �޲ٸ�-���� �ӿ��� ���� ������ �غ��� ���',
'2021.09.02.~ 2021.11.07.',
'10:00 ~ 18:00',
'�������� ������ ���� ������',
'����',
'',
'https://museum.seoul.go.kr/',
'02-724-0274','5ȣ�� ��ȭ���� 7�� �ⱸ���� 450m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200514_147%2F1589436241937q3Wgm_JPEG%2F7bcZB4fLD7-rjHNih5yrPv0S.jpg');

INSERT INTO EXHIBITION VALUES('37.481434631833174', '127.01097152808828',
'����� ���ʱ� ���μ�ȯ�� 2406','���������� �Ѱ����̼���','2021���������ﱹ����Ʈ���','2021.10.31.~ 2021.11.13.','10:00 ~ 19:00','���� ������','���� 8,000�� ��� 7,000��','','https://www.sac.or.kr/','02-580-1300','3ȣ�� �����͹̳ο� 5�� �ⱸ���� 696m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_156%2F1441007000182w9jAC_JPEG%2F11621559_0.jpg');
INSERT INTO EXHIBITION VALUES('37.54590613661096', '127.04242499740417',
'����� ������ ���｣2�� 32-14',
'�������� ���� ���������Ƽ��',
'��Ʈ ���� ��ũ�� [The Art of Banksy - Without Limits]',
'2021.08.20. ~ 2022.02.06.',
'11:00 ~ 20:00 (�Ͽ��� ~ ������)
11:00 ~ 22:00 (����� ~ �����/������)',
'���� �',
'20,000��',
'',
'https://www.theartofbanksy.asia/',
'02-516-2513','���κд缱 ���｣�� 4�� �ⱸ���� 194m','https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190721_93%2F15637028860961utES_JPEG%2FvgYSB7Bs5E7CZ9VYzaZ-vUsg.jpeg.jpg');

select * from EXHIBITION;

COMMIT