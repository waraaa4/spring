### 테이블정의 
```
create table member_table(
	m_number bigint auto_increment,
    m_id varchar(20),
    m_password varchar(20),
    m_name varchar(20),
    m_email varchar(20),
    m_phone varchar(20),
    m_filename varchar(100),
    constraint primary key(m_number)
);
```
```
create table board_table(
	b_number bigint auto_increment,
    b_writer varchar(20),
    b_title varchar(50),
    b_contents varchar(1000),
    b_hits int default 0,
    b_date datetime,
    b_filename varchar(100),
    constraint primary key(b_number)
);
```
```
create table comment_table(
	c_number bigint auto_increment,
    b_number bigint,
    c_writer varchar(20),
    c_contents varchar(200),
    c_date datetime,
    constraint primary key(c_number)
);
```

### 기능
1. 회원관련 기능
    1. 회원가입
        1. 아이디, 비밀번호, 이름, 이메일, 프로필사진을 입력받음
        2. ajax로 아이디 중복확인을 함.
    2. 로그인
        1. 로그인 완료시 페이징처리된 글목록화면으로 이동함
    3. 로그아웃
        1. 로그아웃 완료시 index 페이지로 이동
    4. 일반회원
        1. 게시글작성, 조회 가능 
        2. 본인이 작성한 글에 대해서만 글상세조회시 수정, 삭제 버튼이 보임.
    5. 관리자
        1. 관리자용 페이지가 따로 있음.
        2. 관리자페이지에서 회원 목록 페이지로 이동할 수 있음
        3. 회원목록 페이지에서 회원 삭제 가능함.
2. 게시판 관련 기능
    1. 글쓰기 기능
        1. 글쓰기할 때 작성자는 따로 입력하지 않음. 글쓰기 화면 출력되면 로그인 아이디가 작성자 칸에 입력되어 있음.
        2. 제목, 내용, 첨부파일을 입력할 수 있음.
    2. 페이징 목록 출력 기능
        1. 기본적으로 한화면에 5개씩글이 노출되고 페이지번호는 3개가 나옴.
        2. 한화면에 5개씩, 10개씩 글보기를 select로 선택할 수 있음. (이 기능은 필수는 아니고 선택사항)
    3. 글수정, 글삭제 기능
        1. 작성자 본인만 수정, 삭제 가능 
        2. 관리자는 삭제만 가능 
    4. 검색 기능
        1. 작성자, 제목으로 검색할 수 있음.
        2. 검색결과 페이징처리(선택사항)
3. 댓글 관련 기능 
    1. 댓글 작성 기능
        1. 댓글작성시 글작성과 마찬가지로 작성자는 로그인 아이디가 미리 작성되어 있음. 내용만 작성할 수 있음.
    2. 댓글 삭제 기능(선택사항)
4. 마이페이지 관련 기능 
    1. 로그인하면 마이페이지로 이동할 수 있는 링크가 보임.
    2. 마이페이지로 접속하여 회원정보 수정을 할 수 있음.
    3. 회원정보 수정시 비밀번호를 체크하여 일치하지 않으면 수정처리를 하지 않고 alert 창을 출력함.
