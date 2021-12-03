## 프로젝트 정의 
### 언제?
### 패키지
### DTO

## 테이블정의 
```
create table board_table(
	b_number bigint auto_increment,
    b_writer varchar(20),
    b_password varchar(20),
    b_title varchar(50),
    b_contents varchar(1000),
    b_hits int default 0,
    b_date datetime,
    constraint primary key(b_number));
```

### 정리할 때
1. 글쓰기 기능
save.jsp -> BoardController.save() <-> BoardService.save() <-> BoardRepository.save() <-> mapper.save <-> DB
