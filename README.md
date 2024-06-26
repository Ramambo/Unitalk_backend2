# Unitalk_backend 폴더구조

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── unitalk/
│   │           ├── common/
│   │           │   ├── config/
│   │           │   ├── exception/
│   │           │   ├── model/
│   │           │   └── util/
│   │           ├── counseling/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── emp/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── login/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── online/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   │           ├── program/
│   │           │   ├── controller/
│   │           │   ├── service/
│   │           │   ├── repository/
│   │           │   └── model/
│   ├── resources/
│   │   ├── static/
│   │   │   ├── css/
│   │   │   ├── img/
│   │   │   └── js/
│   │   ├── templates/
│   │   │   ├── fragment/
│   │   │   └── view/
│   │   └── etc/
│   │       ├── ddl/
│   │       └── dummydata/
```
## 폴더구조 정의

- common: 공통 패키지로, 프로젝트 전반에 걸쳐 사용되는 구성, 예외 처리, 모델, 유틸리티 클래스를 포함합니다.
  - config: 설정 관련 클래스
  - exception: 예외 처리 관련 클래스
  - model: 공통 모델 클래스
  - util: 유틸리티 클래스
- 각 도메인별 , 각각의 도메인에 관련된 컨트롤러, 서비스, 리포지토리, 모델 클래스를 포함합니다.
    <br/>(counseling, emp, login, online, program)
  - controller: REST API 또는 웹 컨트롤러 클래스
  - service: 비즈니스 로직을 포함하는 서비스 클래스
  - repository: 데이터 액세스 레이어 클래스
  - model: 도메인 모델 클래스
- resources:
  - static: 정적 리소스 (CSS, 이미지, JavaScript 파일 등)
  - templates: 템플릿 파일 (HTML 템플릿 등)
    - fragment: 템플릿 조각
    - view: 뷰 템플릿
  - etc: 기타 리소스
    - ddl: DDL 파일
    - dummydata: 더미 데이터 파일
    
