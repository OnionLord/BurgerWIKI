BurgerWIKI
==========

OpenBurgerDictionary


Server : Apache Tomcat 7.0 / Java Server Page / MySQL
Client : Android Kitkat (API 19)


WebContent -> Server
BurgerDicApp -> Client

DB(MySQL)
Table “burger_content” : 햄버거의 정보를 담는 Table.

no : Integer, Primary Key

name : Varchar(50), 햄버거 이름

company : Varchar(20), 햄버거 브랜드

calone : Double, 단품 칼로리

calset : Double, 세트 칼로리

priceone : Integer, 단품 가격

priceset : Integer, 세트 가격

image : Varchar(200), 햄버거 사진 URL

content : Varchar(1000), 내용.

modified : Timestamp, 최근에 수정된 시간

moduser : Varchar(50), 최근에 수정한 사용자.



Table “account” : 사용자의 정보를 담는 Table

id : Varchar(50), 사용자 ID

pw : varchar(50), 사용자 비밀번호

email : varchar(50), 사용자 이메일.
