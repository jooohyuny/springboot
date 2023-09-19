SELECT * FROM AUG14_COFFEE;

CREATE TABLE aug14_coffee(
	c_name varchar2(10 char) PRIMARY KEY,
	c_price number(5) NOT NULL
);
INSERT INTO aug14_coffee (c_name, c_price)
VALUES ('아메리카노', 3500);

SELECT * FROM MEMBER;
SELECT * FROM PRODUCT;



SELECT 
INSERT INTO PRODUCT

SELECT *FROM WISHLIST;

SELECT * FROM TOWNNEWS;

CREATE sequence townnews_seq;

INSERT INTO CARROT.TOWNNEWS
(T_ID, T_M_ID, T_TITLE, T_TEXT, T_PHOTO, T_DATE)
VALUES(0, 'test', '테스트입니다', '테스트1번입니다', 'nophoto.png', sysdate);


INSERT INTO TOWNNEWS (T_ID, T_M_ID,T_TITLE, T_TEXT,T_PHOTO,T_DATE)
values(1,"test","테스트","테스트입니다","nophoto.png",TO_DATE('2023-08-25', 'YYYY-MM-DD'));