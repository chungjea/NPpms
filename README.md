![image](https://github.com/chungjea/NPpms/assets/158009772/06ea34dc-ccf9-44ab-8383-c85ab63b6e90)


프로젝트 기간 : 2023.05.01 ~ 2023.06.13

한줄 소개 : 프로젝트를 효율적으로 관리할수있는 PMS 사이트

배포 링크 : http://43.200.172.151:8080/login

테스트 계정 
  - 일반 사원  ID : 199001991 PWD  : test
  - 관리자  ID : 199001004  PWD : test

주요 구현 기능
1. 회원가입 기능
- 사원 정보를 받아 관리자가 사원 등록, 등록시 해당 사원의 이메일로 임시비밀번호 발송
2. 로그인
- 사번, 비밀번호를 입력받아 로그인. 다국어 기능 지원 언어 선택시 해당언어로 변경
3. 비밀번호 찾기
- DB에 저장된 사번을 기반으로 저장된 이베일 주소로 현재 비밀번호 전송
4. 인사관리
- 인사 관리자 권한아이디로만 접근 가능 사원정보를 등록, 수정, 삭제 가능
5. 대시보드
- (참여/담당)중인 프로젝트같은 로그인한 사원의 사내시스템 정보를 한눈에 볼수 있는 페이지
- 진행중인 작업, 리스크의 수를 볼수있는 카드섹션
- (참여/담당)한 진행중인 프로젝트의 진행도,이름,형식 등의 정보를 한눈에 볼수있는 아이콘
- (참여/담당)한 전체 프로젝트의 상태별 수치를 나타낸 원형 그래프
- (참여/담당)한 진행중인 프로젝트의 작업을 상태별 건수를 볼수있는 바 차트 셀렉트박스로 프로젝트
선택
6. 전체 프로젝트들의 정보를 볼수있는 테이블
1) 권한에 따라 (참여/담당)한 프로젝트의 전체정보를 볼수있는 테이블 페이징 처리 되어있음
2) 프로젝트의 상태, 이름으로 프로잭트를 검색할수 있음
7. 프로젝트 생성, 수정, 삭제
- 관리자로 로그인시 프로젝트 생성, 수정, 삭제 가능
1) 생성 - 프로젝트의 이름, 형식 진행 날짜, 표시할 아이콘, 팀원 정보를 입력 받아 프로젝트 생성
2) 수정 - 버튼 클릭시 해당 프로젝트의 정보를 출력, 값을 수정후 수정버튼 클릭시 해당 프로젝트 이름,
형식, 팀원정보, 아이콘 등의 정보변경
3) 삭제 - 삭제버튼 클릭시 DB에서 프로젝트정보, 팀원정보, 업로드된 사진 과같이 해당 프로젝트의
관련된 모든 정보를 삭제
8. 작업관리
- 관리자로 로그인시 선택한 프로젝트에서 속해있는 팀원에게 작업을 추가, 수정, 삭제가능
1) 추가 - 작업의 이름, 진행일수등의 정보를 입력받고 셀렉트 박스에서 팀원을 선택해 작업 부여
2) 수정 - 작업을 더블클릭 또는 진행바를 drag를 통해 작업의 정보를 수정, 수정된 정보에따라 상위,
하위 작업에도 자동으로 영향이가도록 설계
3) 삭제 - delete 버튼 클릭시 작업 삭제, 해당작업에 하위작업존재시 하위작업또한 전부 삭제
9. 공지 게시판
- 선택한 프로젝트의 공지글게시판, 관리자일시 글 등록가능
10. 캘린더 사원의 일정정보를 볼수있는 캘린더
- 일정 추가, 수정, 삭제가능
- 클릭시 상세 일정정보를 볼수있음
- 드래그하여 일정수정 가능
11. 걸제 관리
쌍용교육센터
- 결제 게시판 팀원이 상신할 내용을 등록하면 관리자가 결제, 반려 처리를 할수 있다
12. 리스크 관리
- 프로젝트의 팀원이 프로젝트의 이슈사항등의 리스크를 등록하면 관리자가 확인후 해당 리스크를 처리할
담당자를 배정한다
13. 문서관리
- 전체 게시판 문서, 프로젝트의 문서, 개인문서를 다운로드, 삭제할수 있다