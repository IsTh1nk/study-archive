## 동아리 멤버 테이블 모델링

1. 이메일(email) : PRIMARY_KEY
2. 비밀번호(password)
3. 프로필 이름(profileName)
4. 프로필 소개(profileIntro)
5. 프로필 이미지(profileImage)
6. 학년(grade)
7. 대학(dept)
8. 주전공(major)
9. 부전공(minor)
10. 권한(role)
11. 계정 생성 날짜(createdDate)
12. 회원 정보 수정 날짜(modifiedDate)
13. 계정 상태(enabled)

## 동아리 관심사 테이블 모델링

1. 관심사 번호(interestId) : PRIMARY_KEY
2. 협업도구(BusinessTool)
3. 데브옵스(DevOps)
4. 프로그래밍 언어(Language)
5. 데이터 분석(Data)
6. 그외 관심사(ETC)
7. 이메일 : FOREGIN_KEY

## 동아리 멤버 이력 테이블

1. 이력 번호(careerId) : PRIMARY_KEY
2. 이메일(email) : FOREGIN_KEY
3. 작성 날짜(writtenDate)
4. 수정 날짜(modifiedDate)

## 동아리 멤버 자격증 테이블

1. 자격증 발급 코드(code) : PRIMARY_KEY
2. 자격증명(title)
3. 자격증 발급 기관(organization)
4. 자격증 취득일(acquisitionDate)
5. 자격증 만료일(expiredDate)
6. 자격증 설명(content)
7. 자격증 등급(level)
8. 이력 번호(careerId) : FOREIGN_KEY

## 동아리 멤버 대외활동 테이블

1. 활동 번호(activityId) : PRIMARY_KEY
2. 활동명(activityName)
3. 활동 기간(activityDate)
4. 활동 내용(content)
5. 이력 번호(careerId) : FOREIGN_KEY

## 커뮤니티 게시글 테이블 모델링 (Community)

1. 게시글 번호(postId) : PRIMARY_KEY
2. 게시글 제목(title)
3. 게시글 내용(content)
4. 작성 날짜(writtenDate)
5. 수정 날짜(modifiedDate)
6. 이메일(email) : FOREGIN_KEY

## 커뮤니티 댓글 테이블 모델링 (Community_Comment)

1. 댓글 번호(commentId) : PRIMARY_KEY
2. 댓글 내용(content)
3. 작성 날짜(writtenDate)
4. 수정 날짜(modifiedDate)
5. 이메일(email) : FOREGIN_KEY
6. 게시글 번호(articleNum) : FOREGIN_KEY

## 블로그 포스트 테이블 모델링 (Blog)

1. 포스트 번호(postNum) : PRIMARY_KEY
2. 포스트 제목(postTitle)
3. 포스트 내용(postContent)
4. 작성 날짜(writtenDate)
5. 수정 날짜(modifiedDate)
6. 이메일(email) : FOREGIN_KEY

## 블로그 댓글 테이블 모델링 (Blog_Comment)

1. 댓글 번호(commentId) : PRIMARY_KEY
2. 댓글 내용(commentContent)
3. 작성 날짜(writtenDate)
4. 수정 날짜(modifiedDate)
5. 이메일(email) : FOREGIN_KEY
6. 포스트 번호(postNum) : FOREGIN_KEY

## 오픈소스 게시글 테이블 모델링 (Projects)

1. 프로젝트 번호(projectId) : PRIMARY_KEY
2. 프로젝트 제목(title)
3. 프로젝트 내용(content)
4. 프로젝트 저장소(repository)
5. 작성 날짜(writtenDate)
6. 수정 날짜(modifiedDate)
7. 이메일(email) : FOREGIN_KEY
