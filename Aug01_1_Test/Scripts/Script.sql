CREATE TABLE aug07_coffee(
	c_name varchar2(10 char) PRIMARY KEY,
	c_price number(5) NOT NULL
);

INSERT INTO aug07_coffee (c_name, c_price)
VALUES ('아메리카노', 3500);

INSERT INTO aug07_coffee (c_name, c_price)
VALUES ('테스트', 1000);

SELECT * FROM aug07_coffee;

CREATE TABLE MEMBER(
   m_id varchar2(20 char) PRIMARY KEY,
   m_name varchar2(20 char) NOT NULL,
   m_birth DATE NOT NULL,
   m_loc varchar2(100 char),
   m_pw varchar2(20 char) NOT NULL,
   m_photo varchar2(200 char),
   m_admin number(1) NOT null,
   m_addr varchar2(50 char) NOT null
);
---------------------------------------------------
INSERT INTO MEMBER (m_id, m_name, m_birth, m_loc, m_pw, m_photo, m_admin, m_addr)
VALUES ('user1', 'User One', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'City A', 'password1', 'photo1.jpg', 0, 'Address 1');

INSERT INTO MEMBER (m_id, m_name, m_birth, m_loc, m_pw, m_photo, m_admin, m_addr)
VALUES ('user2', 'User Two', TO_DATE('1992-05-15', 'YYYY-MM-DD'), 'City B', 'password2', 'photo2.jpg', 0, 'Address 2');

-- 나머지 예시 데이터도 이와 같은 형식으로 추가

INSERT INTO MEMBER (m_id, m_name, m_birth, m_loc, m_pw, m_photo, m_admin, m_addr)
VALUES ('user10', 'User Ten', TO_DATE('1985-09-30', 'YYYY-MM-DD'), 'City C', 'password10', 'photo10.jpg', 0, 'Address 10');

COMMIT;



---------------------------------------------------


ALTER table REPORT  MODIFY r_photo varchar2(200 char); 

SELECT * FROM MEMBER;


CREATE TABLE product(
   p_id number(5) PRIMARY KEY,
   p_m_id varchar2(20 char) NOT NULL,
   p_name varchar2(50 char) NOT NULL,
   p_price number(10) NOT NULL,
   p_desc varchar2(500 char) NOT NULL,
   p_category varchar2(20 char) NOT NULL,
   p_view number(5) NOT NULL,
   p_uploadDate DATE NOT NULL,
   p_updateDate DATE NOT null,
   p_photo varchar2(200 char),
   p_state varchar2(20 char) NOT null,
   CONSTRAINT product_member_id
      FOREIGN key(p_m_id) REFERENCES member(m_id)
      ON DELETE cascade
);
-------------------------------------
-- 예시 데이터 1
INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (1, 'user1', 'Product One', 10000, 'Description for Product One', 'Category A', 50, TO_DATE('2023-08-01', 'YYYY-MM-DD'), TO_DATE('2023-08-15', 'YYYY-MM-DD'), 'photo1.jpg', 'Active');

-- 예시 데이터 2
INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (2, 'user2', 'Product Two', 20000, 'Description for Product Two', 'Category B', 70, TO_DATE('2023-08-02', 'YYYY-MM-DD'), TO_DATE('2023-08-14', 'YYYY-MM-DD'), 'photo2.jpg', 'Active');

-- 나머지 예시 데이터도 이와 같은 형식으로 추가

-- 예시 데이터 10
INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (10, 'user1', 'Product Ten', 5000, 'Description for Product Ten', 'Category A', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', 'Active');

INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (11, 'user1', '상품2', 20000, 'Description for Product Ten', 'Category A', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', '판매중');

INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (12, 'user2', '상품3', 30000, 'Description for Product Ten', 'Category B', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', '판매중');

INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (13, 'user2', '상품4', 40000, 'Description for Product Ten', 'Category A', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', '판매중');

INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (14, 'user1', '상품5', 32000, 'Description for Product Ten', 'Category A', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', '판매중');

INSERT INTO PRODUCT (p_id, p_m_id, p_name, p_price, p_desc, p_category, p_view, p_uploadDate, p_updateDate, p_photo, p_state)
VALUES (15, 'user2', '상품5', 32000, 'Description for Product Ten', 'Category B', 25, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('2023-08-16', 'YYYY-MM-DD'), 'photo10.jpg', '판매완료');

COMMIT;

-------------------------------------

SELECT * FROM PRODUCT;

CREATE TABLE sold(
   s_id number(5) PRIMARY key,
   s_m_id varchar2(20 char) NOT NULL,
   s_p_id number(5) NOT NULL,
   s_date DATE NOT NULL,
   s_price number(10) NOT NULL,
   CONSTRAINT sold_member_id
      FOREIGN key(s_m_id) REFERENCES member(m_id)
      ON DELETE CASCADE,
   CONSTRAINT sold_product_id
      FOREIGN key(s_p_id) REFERENCES product(p_id)
      ON DELETE cascade
);

CREATE TABLE bought(
   b_id number(5) PRIMARY key,
   b_m_id varchar2(20 char) NOT NULL,
   b_p_id number(5) NOT NULL,
   b_date DATE NOT NULL,
   b_price number(10) NOT NULL,
   CONSTRAINT bought_member_id
      FOREIGN key(b_m_id) REFERENCES member(m_id)
      ON DELETE CASCADE,
   CONSTRAINT bought_product_id
      FOREIGN key(b_p_id) REFERENCES product(p_id)
      ON DELETE cascade
);
   

CREATE TABLE wishlist(
   w_id number(5) PRIMARY KEY,
   w_m_id varchar2(20) NOT NULL,
   w_p_id number(5) NOT NULL,
   CONSTRAINT wishlist_member_id
      FOREIGN key(w_m_id) REFERENCES member(m_id)
      ON DELETE CASCADE,
   CONSTRAINT wishlist_product_id
      FOREIGN key(w_p_id) REFERENCES product(p_id)
      ON DELETE cascade
);


CREATE TABLE chatroom(
   cr_id number(5) PRIMARY KEY,
   cr_p_id number(5) NOT NULL,
   cr_m_id varchar2(20 char) NOT NULL,
   cr_time timestamp NOT NULL,
   CONSTRAINT chatroom_member_id
      FOREIGN key(cr_m_id) REFERENCES member(m_id)
      ON DELETE CASCADE,
   CONSTRAINT chatroom_product_id
      FOREIGN key(cr_p_id) REFERENCES product(p_id)
      ON DELETE cascade
);



CREATE TABLE chatmessage(
   cm_id number(5) PRIMARY KEY,
   cm_cr_id number(5) NOT NULL,
   cm_m_id varchar2(20 char) NOT NULL,
   cm_text varchar2(100 char) NOT NULL,
   cm_time timestamp NOT NULL,
   CONSTRAINT chatmessage_cr_id
      FOREIGN key(cm_cr_id) REFERENCES chatroom(cr_id)
      ON DELETE CASCADE,
   CONSTRAINT chatmessage_m_id
      FOREIGN key(cm_m_id) REFERENCES member(m_id)
      ON DELETE cascade
);

CREATE TABLE townNews(
   t_id number(5) PRIMARY KEY,
   t_m_id varchar2(20 char) NOT NULL,
   t_title varchar2(50 char) NOT NULL,
   t_text varchar2(500 char) NOT NULL,
   t_photo varchar2(200 char),
   t_date DATE NOT NULL,
   CONSTRAINT townNews_m_id
      FOREIGN key(t_m_id) REFERENCES member(m_id)
      ON DELETE cascade
);


CREATE TABLE townNews_reply(
   tr_id number(5) PRIMARY KEY,
   tr_t_id number(5) NOT NULL,
   tr_m_id varchar2(20 char) NOT NULL,
   tr_text varchar2(100 char) NOT NULL,
   tr_date DATE NOT NULL,
   CONSTRAINT townNews_r_t_id
      FOREIGN key(tr_t_id) REFERENCES townNews(t_id)
      ON DELETE CASCADE,
   CONSTRAINT townNews_r_m_id
      FOREIGN key(tr_m_id) REFERENCES member(m_id)
      ON DELETE CASCADE
);

ALTER TABLE REPORT MODIFY r_m_writerId varchar2(20 char);
ALTER TABLE REPORT MODIFY r_m_reportedId varchar2(20 char);
ALTER TABLE REPORT MODIFY r_category varchar2(20 char);
ALTER TABLE REPORT MODIFY r_text varchar2(500 char);


CREATE TABLE report(
   r_id number(5) PRIMARY KEY,
   r_m_writerId varchar2(20 char) NOT NULL,
   r_m_reportedId varchar2(20 char) NOT NULL,
   r_category varchar2(20 char) NOT NULL,
   r_text varchar2(500 char) NOT NULL,
   r_photo varchar2(200 char),
   r_date DATE NOT NULL,
   CONSTRAINT report_m_writerId
      FOREIGN key(r_m_writerId) REFERENCES member(m_id),
   CONSTRAINT report_m_reportedId
      FOREIGN key(r_m_reportedId) REFERENCES member(m_id)
);

