## 동아리 멤버 테이블

동아리에 가입한 학생들의 정보를 관리하는 테이블입니다.

## 테이블명 : Members

| Column         | Description            |
| -------------- | ---------------------- |
| member_Id (PK) | 동아리 멤버 식별       |
| email          | 계정 이메일 주소       |
| password       | 계정 비밀번호          |
| profile_name   | 프로필 이름(닉네임)    |
| profile_intro  | 프로필 자기소개(255자) |
| profile_image  | 프로필 이미지          |
| grade          | 학년 정보              |
| dept           | 대학(부)               |
| major          | 주전공                 |
| minor          | 부전공                 |
| role           | 계정 권한              |
| created_Date   | 계정 생성 날짜         |
| modified_Date  | 계정 수정 날짜         |
| enabled        | 계정 활성화            |
