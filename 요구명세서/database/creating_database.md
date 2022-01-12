## 데이터베이스 생성하기

## 데이터베이스 계정 생성하기

```
mysql> CREATE USER 'user'@'%'
        IDENTIFIED WITH 'mysql_native_password' BY 'password'
        REQUIRE NONE
        PASSWORD EXPIRE INTERVAL 30 DAY
        ACCOUNT UNLOCK
        PASSWORD HISTORY DEFAULT
        PASSWORD REUSE INTERVAL DEFAULT
        PASSWORD REQUIRE CURRENT DEFAULT;

```
