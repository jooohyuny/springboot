SELECT * FROM coffee;
SELECT * FROM product;

SELECT * FROM "MEMBER";

CREATE TABLE purchase_history (
    ph_id number(5) PRIMARY KEY,
    ph_p_id NUMBER(5) NOT null,
    ph_m_id varchar2(20 char) NOT null,
    FOREIGN KEY (ph_p_id) REFERENCES product (p_id),
    FOREIGN KEY (ph_m_id) REFERENCES member (m_id)
);

SELECT * FROM PURCHASE_HISTORY;

DROP TABLE PURCHASE_HISTORY CASCADE CONSTRAINTS;

CREATE TABLE wishlist(
	w_id number(5) PRIMARY KEY,
	w_m_id varchar2(20 char) NOT NULL,
	w_p_id number(5) NOT NULL,
	CONSTRAINT wishlist_member_id
		FOREIGN KEY (w_m_id) REFERENCES member(m_id)
		ON DELETE CASCADE,
	CONSTRAINT wishlist_product_id
		FOREIGN KEY (w_p_id) REFERENCES product(p_id)
		ON DELETE CASCADE
);
CREATE SEQUENCE wishlist_seq;
CREATE SEQUENCE purchase_seq;

SELECT * FROM TOWNNEWS;
SELECT * FROM WISHLIST;
SELECT * FROM REPORT;

SELECT * FROM TOWNNEWS;